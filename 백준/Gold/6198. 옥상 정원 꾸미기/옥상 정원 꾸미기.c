#include <stdio.h>
#include <stdlib.h>

#define MAX 80000

int main(void)
{
        int n;
        scanf("%d", &n);

        int *b = (int *)malloc(sizeof(int) * n);
        for(int i = 0; i < n; i++)
                scanf("%d", &b[i]);

        int stack[MAX];
        int top = -1;
        long long result = 0;

        for(int i = 0; i < n; i++)
        {
                while (top >= 0 && stack[top] <= b[i])
                        top --;
                result += (top+1);
                stack[++top] = b[i];
        }
        free(b);
        printf("%lld\n", result);
        return (0);
}