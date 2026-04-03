#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct table {
    char var[10];
    int value;
};

struct table tbl[20];
int i, j, n = 0;

void create();
void insert();
void modify();
int search(char variable[], int n);
void display();

int main() {
    int ch, result;
    char v[10];

    do {
        printf("\n1.Create\n2.Insert\n3.Modify\n4.Search\n5.Display\n6.Exit\n");
        scanf("%d", &ch);

        switch(ch) {
            case 1: create(); break;
            case 2: insert(); break;
            case 3: modify(); break;

            case 4:
                printf("Enter variable to search:\n");
                scanf("%s", v);
                result = search(v, n);

                if(result == -1)
                    printf("Variable not found\n");
                else
                    printf("Location: %d Value: %d\n",
                           result + 1, tbl[result].value);
                break;

            case 5: display(); break;
            case 6: exit(0);
        }

    } while(ch != 6);

    return 0;   // removed getch()
}

// Create
void create() {
    printf("Enter number of entries:\n");
    scanf("%d", &n);

    for(i = 0; i < n; i++) {
        while(1) {
            scanf("%s%d", tbl[i].var, &tbl[i].value);

            if(tbl[i].var[0] >= '0' && tbl[i].var[0] <= '9') {
                printf("Variable must start with alphabet\n");
                continue;
            }

            int duplicate = 0;
            for(j = 0; j < i; j++) {
                if(strcmp(tbl[i].var, tbl[j].var) == 0) {
                    printf("Variable already exists\n");
                    duplicate = 1;
                    break;
                }
            }

            if(!duplicate) break;
        }
    }
    display();
}

// Insert
void insert() {
    if(n >= 20) {
        printf("Table full\n");
        return;
    }

    while(1) {
        scanf("%s%d", tbl[n].var, &tbl[n].value);

        if(tbl[n].var[0] >= '0' && tbl[n].var[0] <= '9') {
            printf("Invalid variable name\n");
            continue;
        }

        int duplicate = 0;
        for(j = 0; j < n; j++) {
            if(strcmp(tbl[n].var, tbl[j].var) == 0) {
                printf("Variable exists\n");
                duplicate = 1;
                break;
            }
        }

        if(!duplicate) break;
    }

    n++;
    display();
}

// Modify
void modify() {
    char variable[10];
    int result;

    scanf("%s", variable);
    result = search(variable, n);

    if(result == -1)
        printf("Variable not found\n");
    else
        scanf("%s%d", tbl[result].var, &tbl[result].value);

    display();
}

// Search
int search(char variable[], int n) {
    for(i = 0; i < n; i++) {
        if(strcmp(tbl[i].var, variable) == 0)
            return i;
    }
    return -1;
}

// Display
void display() {
    printf("VARIABLE\tVALUE\n");
    for(i = 0; i < n; i++)
        printf("%s\t\t%d\n", tbl[i].var, tbl[i].value);
}