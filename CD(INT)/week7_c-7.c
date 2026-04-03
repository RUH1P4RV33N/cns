#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int stack[MAX];
int top = -1;

// Push operation (allocate memory)
void push(int value) {
    if (top == MAX - 1) {
        printf("Stack Overflow (Memory Full)\n");
        return;
    }
    stack[++top] = value;
    printf("Allocated %d\n", value);
}

// Pop operation (deallocate memory)
void pop() {
    if (top == -1) {
        printf("Stack Underflow (No Memory to Free)\n");
        return;
    }
    printf("Deallocated %d\n", stack[top--]);
}

// Display stack
void display() {
    if (top == -1) {
        printf("Stack is Empty\n");
        return;
    }
    printf("Stack Elements: ");
    for (int i = top; i >= 0; i--) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main() {
    int choice, value;

    while (1) {
        printf("\n1. Allocate (Push)\n2. Deallocate (Pop)\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to allocate: ");
                scanf("%d", &value);
                push(value);
                break;

            case 2:
                pop();
                break;

            case 3:
                display();
                break;

            case 4:
                exit(0);

            default:
                printf("Invalid Choice\n");
        }
    }
}