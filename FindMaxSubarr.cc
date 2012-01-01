#include <iostream>
#include <stdio.h>
using namespace std;

struct MaxArr {
    int lp;
    int rp;
    double sum;
};

struct MaxArr FindMaxArr(int*,int,int);
int main()
{
    struct MaxArr ans= {0,0,0.0};
    int len;
    cout<<"Input the length of array:"<<endl;
    cin>>len;
    int a[len];
    cout<<"Input the array:"<<endl;
    for(int i=0; i<len; i++) cin>>a[i];
    ans = FindMaxArr(a,0,len-1);
    printf("From %d to %d is the max sum = %f\n",ans.lp,ans.rp,ans.sum);
    return 0;
}
//o(n)
struct MaxArr FindMaxArr(int* A,int low,int hight) {
    int sum=0;
    int m=low;
    struct MaxArr result= {0,0,0.0};
    for(int i=low; i<hight; i++) {
        sum+=A[i];
        if(sum>result.sum) {
            result.sum=sum;
            result.lp=m;
            result.rp=i;
        } else {
            if(sum<0) {
                sum=0;
                m=i+1;
            }
        }

    }
    return result;
}