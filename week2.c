#include<stdio.h>
int main()
{
    char* str="Hello World";
    printf("AND\n");
    for(int i=0;str[i]!='\0';i++)
    {
        printf("%c AND 127 = %d \n",str[i],str[i]&127);
    }
    printf("XOR\n");
    for(int i=0;str[i]!='\0';i++)
    {
        printf("%c XOR 127 = %d \n",str[i],str[i]^127);
    }
    printf("XOR\n");
    for(int i=0;str[i]!='\0';i++)
    {
        printf("%c XOR 127 = %d \n",str[i],str[i]|127);
    }
}