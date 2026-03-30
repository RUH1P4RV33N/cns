#include<stdio.h>
int main()
{
    char* str="Hello World";
    for(int i=0;str[i]!='\0';i++)
    {
        printf("%c XOR 0 = %c \n",str[i],str[i]^0);
    }
}