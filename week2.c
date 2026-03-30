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

// H AND 127 = 72 
// e AND 127 = 101 
// l AND 127 = 108 
// l AND 127 = 108 
// o AND 127 = 111 
//   AND 127 = 32 
// W AND 127 = 87 
// o AND 127 = 111 
// r AND 127 = 114
// l AND 127 = 108
// d AND 127 = 100
// XOR
// H XOR 127 = 55
// e XOR 127 = 26
// l XOR 127 = 19
// l XOR 127 = 19
// o XOR 127 = 16
//   XOR 127 = 95
// W XOR 127 = 40
// o XOR 127 = 16
// r XOR 127 = 13
// l XOR 127 = 19
// d XOR 127 = 27
// XOR
// H XOR 127 = 127
// e XOR 127 = 127
// l XOR 127 = 127
// l XOR 127 = 127
// o XOR 127 = 127
//   XOR 127 = 127
// W XOR 127 = 127
// o XOR 127 = 127
// r XOR 127 = 127
// l XOR 127 = 127
// d XOR 127 = 127