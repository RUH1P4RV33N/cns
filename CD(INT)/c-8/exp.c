#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

const char *input;
int i = 0;

void E();
void Eprime();
void T();
void Tprime();
void F();

void error() {
    printf("Invalid Expression\n");
    exit(1);
}

void E() {
    T();
    Eprime();
}

void Eprime() {
    if (input[i] == '+') {
        i++;
        T();
        Eprime();
    }
    // else epsilon
}

void T() {
    F();
    Tprime();
}

void Tprime() {
    if (input[i] == '*') {
        i++;
        F();
        Tprime();
    }
    // else epsilon
}

void F() {
    if (input[i] == '(') {
        i++;
        E();
        if (input[i] == ')') {
            i++;
        } else {
            error();
        }
    } else if (isalpha(input[i])) {
        i++;
    } else {
        error();
    }
}

int main() {
    char expr[100];                  /* ← fixed: removed stray text after this */

    printf("Enter expression: ");
    scanf("%s", expr);
    input = expr;

    E();

    if (input[i] == '\0') {
        printf("Valid Expression\n");
    } else {
        printf("Invalid Expression\n");
    }

    return 0;
}