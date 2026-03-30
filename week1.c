#include<stdio.h>
int main()
{
    char* str="Hello World";
    for(int i=0;str[i]!='\0';i++)
    {
        printf("%c XOR 0 = %c \n",str[i],str[i]^0);
    }
}

// H XOR 0 = H 
// e XOR 0 = e 
// l XOR 0 = l 
// l XOR 0 = l 
// o XOR 0 = o 
//   XOR 0 =   
// W XOR 0 = W 
// o XOR 0 = o 
// r XOR 0 = r 
// l XOR 0 = l 
// d XOR 0 = d 