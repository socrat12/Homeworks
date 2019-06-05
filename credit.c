#include<stdio.h>
#include<cs50.h>
#include<math.h>
long num();
int symbol;
int i = 1;
int sum1 = 0;
int sum2 = 0;
long numberfin;
long number;
long number1;

int main(void)
{
    numberfin = num();
    number1 = number;
    number = number1 / 10;
    while (number >= 1 || number1 >= 1)
    {
        if (number > 9)
        {
            i = i + 2;
        }
        else if (number1 > 9)
        {
            i++;
        }
        
        if (number % 10 > 4)
        {
            sum2 = sum2 + ((number % 10 * 2) % 10 + ((number % 10 * 2) - (number % 10 * 2) % 10) / 10);
        }
        else
        {
            sum2 = sum2 + number % 10 * 2;
        }
        sum1 = sum1 + number1 % 10;  
        number = (number - number % 100) / 100;
        number1 = (number1 - number1 % 100) / 100;
    }
    
    if ((sum1 + sum2) % 10 == 0 && i == 15) 
    {
        switch (numberfin / (long)pow(10, i - 2))
        {
            case 34:       
            case 37:
                printf("AMEX\n");
                number = 1;
                break;
        }
    }
    if ((sum1 + sum2) % 10 == 0 && i == 16)
    {
        switch (numberfin / (long)pow(10, i - 2))
        { 
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                printf("MASTERCARD\n");
                number = 1;
                break;
        }
    }
    if ((sum1 + sum2) % 10 == 0 && i == 16)
    {
        switch (numberfin / (long)pow(10, i - 1))
        {
            case 4:
                printf("VISA\n");
                number = 1;                      
                break;                              
        }
    }
    if (number != 1)
    {
        printf("INVALID\n");  
    }
}                   

long num(void)
{ 
   
    do
    {
        number = get_long("Number: ");
        if (number < 1000000000000 || number > 9999999999999999)
        {
            break;
        }
           
    }
    while (number < 1000000000000 || number > 9999999999999999);
    return number;
}
