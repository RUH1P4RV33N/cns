#include <ctype.h>
#include <stdio.h>

int main(void) {
    int c, d, i;
    char s[32];

    while ((c = getchar()) != EOF) {
        if (isalpha(c) || c == '_') {
            for (i = 0; isalnum(c) || c == '_'; c = getchar()) s[i++] = c;
            s[i] = 0;
            printf("Identifier: %s\n", s);
            if (c != EOF) ungetc(c, stdin);
        } else if (isdigit(c)) {
            for (i = 0; isdigit(c); c = getchar()) s[i++] = c;
            s[i] = 0;
            printf("Constant: %s\n", s);
            if (c != EOF) ungetc(c, stdin);
        } else if (c == '/') {
            d = getchar();
            if (d == '/') {
                printf("Comment: //");
                while ((c = getchar()) != EOF && c != '\n') putchar(c);
                printf("\n");
            } else {
                printf("Operator: /\n");
                if (d != EOF) ungetc(d, stdin);
            }
        } else if (c == '+' || c == '-' || c == '*' || c == '=') {
            printf("Operator: %c\n", c);
        }
    }
    return 0;
}



// #include <stdio.h>
// #include <string.h>
// #include <ctype.h>

// // Function to check keyword or identifier
// void keyword(char str[]) {
//     if(!strcmp(str,"for") || !strcmp(str,"while") || !strcmp(str,"do") ||
//        !strcmp(str,"int") || !strcmp(str,"float") || !strcmp(str,"char") ||
//        !strcmp(str,"double") || !strcmp(str,"static") ||
//        !strcmp(str,"switch") || !strcmp(str,"case"))
//         printf("%s is a keyword\n", str);
//     else
//         printf("%s is an identifier\n", str);
// }

// int main() {
//     char c, str[20];
//     int num[100], ncount = 0;
//     int k = 0, lineno = 0;

//     printf("Enter the C program (Ctrl+D to stop):\n");

//     while((c = getchar()) != EOF) {

//         // Numbers
//         if(isdigit(c)) {
//             int val = c - '0';
//             while(isdigit(c = getchar()))
//                 val = val * 10 + (c - '0');
//             num[ncount++] = val;
//             ungetc(c, stdin);
//         }

//         // Identifiers / Keywords
//         else if(isalpha(c)) {
//             str[k++] = c;
//             while(isalnum(c = getchar()) || c == '_' || c == '$')
//                 str[k++] = c;

//             str[k] = '\0';
//             keyword(str);
//             k = 0;
//             ungetc(c, stdin);
//         }

//         // Count lines
//         else if(c == '\n') {
//             lineno++;
//         }

//         // Special characters
//         else if(c != ' ' && c != '\t') {
//             printf("%c is a special character\n", c);
//         }
//     }

//     // Print numbers
//     printf("\nThe numbers in the program are: ");
//     for(int i = 0; i < ncount; i++) {
//         printf("%d ", num[i]);
//     }

//     // Print line count
//     printf("\nTotal number of lines: %d\n", lineno);

//     return 0;
// }