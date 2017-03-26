import java.util.Scanner;
//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 3
//Brief description of file contents: Converts, withdraws, and deposits currency

public class CurrencyExchange {

    private static double balance = 0;

    /**
     * Get the current balance of the account
     */
    public static double getBalance() {
        return balance;
    }

     /**
     * Update the balance of current account, will do a roundup to 2 significant digits
     *
     * @return if update succeed, will return true. If failed, return false
     */
    private static boolean updateBalance(double newBalance) {

        balance = Math.round(newBalance * 100) / 100.0;
        if (balance >= 0) {
            return true;
        } else
            return false;
    }

/****************************************************************
*        Do not modify anything above this line                 *
*****************************************************************/

    /**
     * main method, put your business logic and console input here
     */
    public static void main(String[] args) {
        //Please DO NOT create any other Scanner objects
        Scanner scanSomethingImGivingUpOnYou = new Scanner(System.in);
    	int currency;
        System.out.println("Welcome to Currency Exchange 2.0");
		System.out.println();
		printConversionTable();
		System.out.println();
		
		int menu = mainMenuOptionSelector(scanSomethingImGivingUpOnYou);
		while(!(menu < 1 || menu > 4)){
			switch (menu){
				case 1: {
					System.out.println("Your current balance is: "+getBalance());
					break;
				}
				case 2: {
					
					currency = currencyMenuOptionSelector(scanSomethingImGivingUpOnYou);
					
					boolean depositSuccess = false;
					while(depositSuccess == false){
						
						System.out.println("Please enter the deposit amount: ");
						double depos = scanSomethingImGivingUpOnYou.nextDouble();
				
						depositSuccess = deposit(depos, currency);
						if(depos <= 0){
							depositSuccess = true;
							break;
						}
					}
					
					System.out.println();
					break;
					
				}
				case 3: {
					currency = currencyMenuOptionSelector(scanSomethingImGivingUpOnYou);
					System.out.println("Please enter the withdrawal amount: ");
					double withdr = scanSomethingImGivingUpOnYou.nextDouble();
					boolean withdrawSuccess = withdraw(withdr, currency);
					System.out.println();
					break;
					
				}
				case 4: {
					if(getBalance()==0){
						System.out.println("Your remaining balance is 0.0 U.S. Dollars");
					}
					else
						withdraw(getBalance(), 1);
					System.out.println("Goodbye");
					System.exit(0);
				}
			}
			menu = mainMenuOptionSelector(scanSomethingImGivingUpOnYou);
		}
        
        // this is where you will write the code that invokes (calls) 
        // the methods below to facilitate the successful running of 
        // your code

    }


    /**
     * deposit the amount of a specific currency to the account
     *
     * @param amount       the amount to be deposited.
     * @param currencyType the currency type will be the same as the type number used
     *                     in the convertCurrency(double, int, boolean) method. An Invalid type will result in a
     *                     deposit failure.
     * @return if deposit succeed, will return true. If failed, return false
     */
    public static boolean deposit(double amount, int currencyType) {
    	boolean isDeposit = true;
    	double balance2 = getBalance();
    	double depos = convertCurrency(amount, currencyType, true);
    	if(balance2+depos > 0){
    		updateBalance(balance2+depos);
    	}
    	System.out.println(logTransaction(amount, currencyType, isDeposit));
    	if(amount <= 0){
    		return false;
    	}
    	return true;
    }

    /**
     * withdraw the value amount with a specific currency from the account. The withdraw amount should never exceed the current account balance, or the withdrawal will fail. If the currency is other than USD, a 0.5% convenience fee will be charged
     *
     * @param amount       the amount to be withdrawn.
     * @param currencyType the currency type will be the same as the type number used
     *                     in the convertCurrency(double, int, boolean) method. An invalid
     * 		         type will result a withdraw failure.
     * @return if withdraw succeed, will return true. If failed, return false
     */
    

    public static boolean withdraw(double amount, int currencyType) {
    	boolean isDeposit = false;
    	double balance2 = getBalance();
    	double withdr = convertCurrency(amount, currencyType, true);
    	if(currencyType != 1){
    		withdr = (withdr * 1.005);
    	}
    	if(withdr > balance2){
    		System.out.println(logTransaction(amount, 0, isDeposit));
    		return false;
    	}
    	else if(amount <= 0){
    		System.out.println(logTransaction(amount, currencyType, isDeposit));
    		return false;
    	}
    	else{
        		updateBalance(balance2 - withdr);
        		System.out.println(logTransaction(amount, currencyType, isDeposit));
    	}
    	return true;
    }

    /**
     * Convert the value amount between U.S. dollars and a specific currency.
     *
     * @param amount         The amount of the currency to be converted.
     * @param currencyType   The integer currencyType works as follows:
     *                       1 for usd (U.S. Dollars)
     *                       2 for eur (Euros)
     *                       3 for bri (British Pounds)
     *                       4 for inr (Indian Rupees)
     *                       5 for aus (Australian Dollars)
     *                       6 for cnd (Canadian Dollars)
     *                       7 for sid (Singapore Dollars)
     *                       8 for swf (Swiss Francs)
     *                       9 for mar (Malaysian Ringgits)
     *                       10 for jpy (Japanese Yen)
     *                       11 for cyr (Chinese Yuan Renminbi)
     * @param isConvertToUSD Tells the direction of the conversion. If the value is true, then the conversion is from a
     *                       foreign currency to USD. If the value is false, then the conversion is from USD to the
     *                       foreign currency
     * @return the converted amount
     */
    public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD) {
    	double convertedAmount = 0;
    	if(isConvertToUSD == true){
            switch(currencyType){
    	        case 1: {
    	        	convertedAmount = amount / 1.00;
    	       		break;
    	       	}
    	       	case 2: {
    	       		convertedAmount = amount / 0.89;
    	       		break;
    	       	}
            	case 3: {
            		convertedAmount = amount / 0.78;
   	        		break;
   	        	}
   	        	case 4: {
   	        		convertedAmount = amount / 66.53;
    	        	break;
    	        }
    	        case 5: {
    	        	convertedAmount = amount / 1.31;
    	        	break;
    	        }
    	        case 6: {
    	        	convertedAmount = amount / 1.31;
    	        	break;
    	        }
    	        case 7: {
    	        	convertedAmount = amount / 1.37;
    	        	break;
    	        }
    	        case 8: {
    	        	convertedAmount = amount / 0.97;
    	        	break;
    	        }
    	        case 9: {
    	        	convertedAmount = amount / 4.12;
    	        	break;
    	        }
    	        case 10: {
    	        	convertedAmount = amount / 101.64;
    	        	break;
    	        }
    	        case 11: {
    	        	convertedAmount = amount / 6.67;
    	        	break;
    	       	}
    	        default: {
    	        	System.out.println("Input failed validation. Please try again.");
    	        	break;
    	        }    		
            }
        }
    	
    	else{
            switch(currencyType){
            	case 1: {
        	        convertedAmount = amount * 1.00;
        	       	break;
        	    }
        	    case 2: {
        	       	convertedAmount = amount * 0.89;
        	        break;
        	    }
                case 3: {
                	convertedAmount = amount * 0.78;
       	        	break;
       	        }
       	        case 4: {
       	        	convertedAmount = amount * 66.53;
        	        break;
        	    }
        	    case 5: {
        	        convertedAmount = amount * 1.31;
        	        break;
        	    }
        	    case 6: {
        	        convertedAmount = amount * 1.31;
        	        break;
        	    }
        	    case 7: {
        	        convertedAmount = amount * 1.37;
        	        break;
        	    }
        	    case 8: {
        	        convertedAmount = amount * 0.97;
        	        break;
        	    }
        	    case 9: {
        	        convertedAmount = amount * 4.12;
        	        break;
        	    }
        	    case 10: {
        	    	convertedAmount = amount * 101.64;
        	        break;
        	    }
        	    case 11: {
        	        convertedAmount = amount * 6.67;
        	        break;
        	    }
        	    default: {
        	        System.out.println("Input failed validation. Please try again.");
        	        break;
        	    }    		
            } 
        }
    	return convertedAmount;

    }
    /**
     * Displays message at the end of the withdraw, deposit, and endTransaction stating
     * how much the user just withdrew/deposited and what type (this will be used in both features B, C and D of the
     * main menu).
     *
     * @param amount       the amount of currency withdrew/deposited
     * @param currencyType the currency type will be the same as the type number used
     *                     in {@link #convertCurrency(double, int, boolean)}
     * @param isDeposit    if true log the deposit transaction, false log the withdraw transaction
     * @return Return the formatted log message as following examples:
     * You successfully withdrew 10.0 U.S. Dollars
     * You successfully deposited 30.0 Japanese Yen
     * <p>
     * The invalid input like invalid currencyType or negative amount,
     * will return a “Logging Error”
     */
    private static String logTransaction(double amount, int currencyType, boolean isDeposit) {
       String log = "";
       if(amount <= 0){
    	   return "Logging Error";
       }
       if(currencyType == 0){
		   System.out.println("Error: Insufficient funds.");
		   return "Logging Error";
       }
       
       if (isDeposit == true){
    	   log += "You successfully deposited ";
       }
       
       else {
    	   log += "You successfully withdrew ";
    	   }
       
       log += amount + " ";
       switch(currencyType){
       	  
	      case 1:{
	    	  log += "U.S. dollars";
	    	  break;
	      }
	      case 2:{
	    	  log += "Euros";
	    	  break;
	      }
	      case 3:{
	    	  log += "British Pounds";
	    	  break;
	      }
	      case 4:{
	    	  log += "Indian Rupees";
	    	  break;
	      }
	      case 5:{
	    	  log += "Australian Dollars";
	    	  break;
	      }
	      case 6:{
	    	  log += "Canadian Dollars";
	    	  break;
	      }
	      case 7:{
	    	  log += "Singapore Dollars";
	    	  break;
	      }
	      case 8:{
	    	  log += "Swiss Francs";
	    	  break;
	      }
	      case 9:{
	    	  log += "Malaysian Ringgits";
	    	  break;
	      }
	      case 10:{
	    	  log += "Japanese Yen";
	    	  break;
	      }
	      case 11:{
	    	  log += "Chinese Yuan Renminbi";
	    	  break;
	      }
    	   
       }
       return log;
    }

    /**
     * Prints the currency menu (see output examples), allows the user to make a selection from available currencies
     *
     * @param input the Scanner object you created at the beginning of the main method. Any value other than the
     *              11 valid valid currency types should generate an invalid value prompt. Print the list again
     *              and prompt user to select a valid value from the list. the currency type will be the same as
     *              the type number used in {@link #convertCurrency(double, int, boolean)}
     * @return an integer from 1-11 inclusive representing the user’s selection.
     * 
     * 
     */
    
    private static int currencyMenuOptionSelector(Scanner input) {
		int currencySelection;
		System.out.println("Please select the currency type:");
		System.out.println("1. U.S. Dollars");
		System.out.println("2. Euros");
		System.out.println("3. British Pounds");
		System.out.println("4. Indian Rupees");
		System.out.println("5. Australian Dollars");
		System.out.println("6. Canadian Dollars");
		System.out.println("7. Singapore Dollars");
		System.out.println("8. Swiss Francs");
		System.out.println("9. Malaysian Ringgits");
		System.out.println("10. Japanese Yen");
		System.out.println("11. Chinese Yuan Renminbi");
		currencySelection = input.nextInt();
		while(currencySelection > 11 || currencySelection < 1) {
			System.out.println("Input failed validation. Please try again.");
			System.out.println("Please select the currency type:");
			System.out.println("1. U.S. Dollars");
			System.out.println("2. Euros");
			System.out.println("3. British Pounds");
			System.out.println("4. Indian Rupees");
			System.out.println("5. Australian Dollars");
			System.out.println("6. Canadian Dollars");
			System.out.println("7. Singapore Dollars");
			System.out.println("8. Swiss Francs");
			System.out.println("9. Malaysian Ringgits");
			System.out.println("10. Japanese Yen");
			System.out.println("11. Chinese Yuan Renminbi");
			currencySelection = input.nextInt();
		}
		return currencySelection;
		
    }

    /**
     * Prints the main menu (see output examples), allows the user to make a selection from available operations
     *
     * @param input the Scanner object you created at the beginning of the main method. Any value other than the 4
     *              valid selections should generate an invalid value prompt. Print the list again and prompt user to
     *              select a valid value from the list.
     * @return an integer from 1-4 inclusive representing the user’s selection.
     */
    private static int mainMenuOptionSelector(Scanner input) {
    	int menuSelection;
		System.out.println("Please select an option from the list below:");
		System.out.println("1. Check the balance of your account");
		System.out.println("2. Make a deposit");
		System.out.println("3. Withdraw an amount in a specific currency");
		System.out.println("4. End your session (and withdraw all remaining currency in U.S. Dollars)");
		System.out.println();
		menuSelection = input.nextInt();
		if (menuSelection > 4 || menuSelection < 1) {
			System.out.println("Input failed validation. Please try again.");
			return mainMenuOptionSelector(input);
		}
		else {
			return menuSelection;
		}

    }

    /**
     * Prints the conversion table at the start of the program (see the output examples).
     */
    private static void printConversionTable() {
    	System.out.println("Current rates are as follows: ");
    	System.out.println();
    	System.out.println("1 -  U.S. Dollar - 1.00");
    	System.out.println("2 - Euro - 0.89");
    	System.out.println("3 - British Pound - 0.78");
    	System.out.println("4 - Indian Rupee - 66.53");
    	System.out.println("5 - Australian Dollar - 1.31");
    	System.out.println("6 - Canadian Dollar - 1.31");
    	System.out.println("7 - Singapore Dollar - 1.37");
    	System.out.println("8 - Swiss Franc - 0.97");
    	System.out.println("9 - Malaysian Ringgit - 4.12");
    	System.out.println("10 - Japanese Yen - 101.64");
    	System.out.println("11 - Chinese Yuan Renminbi - 6.67");
    }
}
