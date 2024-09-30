package discussionboard;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class DiscussionBoard{
    public static void main(String[] args) {
        final int BOARD_MAX = 10;
        HashSet<Character> vowels = new HashSet<>();
        
        //adding the vowels into the set
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        Scanner scan = new Scanner(System.in);

        
        String [] messageBoard = new String[BOARD_MAX];
        String [] associatedName = new String[BOARD_MAX];
        int count = 0;


        int numVowels =0;

        for(int i = 0; i < BOARD_MAX; i++){
            messageBoard[i] = ""; //initialize empty string
            associatedName[i] = "";
        }
        int option = -1;



        while(option!= 9){
            
            printOptions();

            option = scan.nextInt();

            scan.nextLine();
        switch(option){
            case 1:
               // System.out.println("Post new message");
               //places the post in the next availible spot
                    String post = scan.nextLine();

                    for(int i = 0; i < BOARD_MAX; i++){
                        if(messageBoard[i].equals("")){
                            messageBoard[i] = post; //assign post into empty arrat spot


                            //tokenize entire post
                            StringTokenizer str = new StringTokenizer(post, " ");
                          
                                //get the name
                                associatedName[i] = str.nextToken();
                                count++; //increaqse the count of posts

                                
                                //count the vowels in the name
                            //     for(char let:  associatedName[i].toLowerCase().toCharArray()){
                            //         //if the vowel exists    
                            //         if(vowels.contains(let)){
                            //             numVowels++;
                            //             }
                            // }

                            //count the rest of the vowels in the post
                            str.nextToken(); //get rid of says
                            while (str.hasMoreTokens()) { 

                              for(char let: str.nextToken().toLowerCase().toCharArray()){
                                    //if the vowel exists    
                                    if(vowels.contains(let)){
                                        numVowels++;
                                    }
                                }
                            }
                            break;
                        }
                    }

                break;
            case 2:
                //System.out.println("Print all post");
                for(int i = 0; i < BOARD_MAX; i++){
                    if(!messageBoard[i].equals("")){
                        System.out.println(messageBoard[i]);
                    }
                }
                break;
            case 3:
                //System.out.println("Print all of posts in reverse");
                for(int i = BOARD_MAX-1; i >= 0; i--){
                    if(!messageBoard[i].equals("")){
                        System.out.println(messageBoard[i]);
                    }
                }
                break;
            case 4:
           // System.out.println("Print number of posts entered so far ");
                System.out.println(count); //from above
         
            break;
            
            case 5:
                //System.out.println("Print all posts from a user");
                String toSearch = scan.nextLine();
                int numberOfPosts = 0;

                System.out.println("Post by "+ toSearch);
                for(int i = 0; i < BOARD_MAX; i++){
                    String currentName = associatedName[i].toUpperCase();
                   
                    if(toSearch.toUpperCase().equals(currentName)){
                        numberOfPosts++;
                        System.out.println(numberOfPosts + ". " +messageBoard[i]+"\n");
                    }

                    //else ignore
                }
                break;
            case 6:
            //System.out.println("Print the number of vowels across all posts");
            System.out.println("Number of vowels are: "+numVowels ); 
            break;
            
            case 7:
                //System.out.println("Performs a search of posts containing a given word (case sensitive)");
                System.out.println("Do you have a word that you want to find? (case sensitive)");
                String word = scan.nextLine();

                for(int i = 0; i < BOARD_MAX;i++){

                    String message = messageBoard[i];
                    StringTokenizer temp = new StringTokenizer(message, " ");


                    while(temp.hasMoreTokens()){
                        String curWord = temp.nextToken();
                        if(curWord.contains(word)){
                            System.out.println(message); 
                        
                            break; //goes onto the next posts
                        } 
                            
                    }
                }
                

                 break;
            case 8:
            //System.out.println("Performs a search of posts containing a given word (case insensitive)");

            System.out.println("Do you have a word that you want to find? (case insensitive)");
            String word2 = scan.nextLine();

            for(int i = 0; i < BOARD_MAX;i++){

                String message = messageBoard[i];
                StringTokenizer temp = new StringTokenizer(message, " ");


                while(temp.hasMoreTokens()){
                    String curWord = temp.nextToken();
                    if(curWord.toLowerCase().contains(word2.toLowerCase())){
                        System.out.println(message); 
                  
                        break; //goes onto the next posts
                    } 
                        
                }
            }
            break;
            case 9:
            scan.close();
            break;
            default:
                System.out.println("Invalid try again");
                break;
        }
        }

    }

    public static void printOptions() {
        
                System.out.println("1. Post new message");
                System.out.println("2. Print all post");
                
                System.out.println("3. Print all of posts in reverse");
            System.out.println("4. Print number of posts entered so far ");

            
            
                System.out.println("5. Print all posts from a user");

            
            System.out.println("6. Print the number of vowels across all posts");

            
            
                System.out.println("7. Perform a search of posts containing a given word (case sensitive)");
                
            
            System.out.println("8. Perform a search of posts containing a given word (case insensitive)");
            
            System.out.println("9. End program");

                

        
    }
}