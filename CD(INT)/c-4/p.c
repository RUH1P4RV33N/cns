#include <stdio.h>
#include <string.h>

const char *input;
int i = 0;

void S();
void L();
void Lprime();
void error();

void match(char expected) {
    if (input[i] == expected) {
        i++;
    } else {
        error();
    }
}

void S() {
    if (input[i] == '(') {
        match('(');
        L();
        match(')');
    } else if (input[i] == 'a') {
        match('a');
    } else {
        error();
    }
}

void L() {
    S();
    Lprime();
}

void Lprime() {
    if (input[i] == ',') {
        match(',');
        S();
        Lprime();
    }
    // else ε (do nothing)
}

void error() {
    printf("❌ Syntax Error at position %d\n", i);
    exit(1);
}

int main() {
    char expr[100];
    printf("Enter string (e.g., (a,a), a, ((a,a),a), etc.): ");
    scanf("%s", expr);
    input = expr;

    S();

    if (input[i] == '\0') {
        printf("✅ Valid String\n");
    } else {
        printf("❌ Invalid String (Extra characters found)\n");
    }

    return 0;
}
