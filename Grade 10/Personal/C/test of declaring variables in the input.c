#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

void main()
{

   int a;
   
   printf("Enter a number: ");
   scanf("%d", &a);
   printf("%d", a);
   
   // this fails
   // printf("%d", int a = 3);
   /* but there are two kinds of comments in c */

}