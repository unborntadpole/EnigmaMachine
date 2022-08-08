public class Main {
    private static char[] rotorpos = new char[3];
    private static int[][] rotor = new int[3][26];
    private static int[][] rotorShift = {{2,2,2,-3,-3,1,2,-2,-1,2,-1,1,2,-3,3,-2,3,3,-3,-3,2,-3,-1,2,-1,-1},{1,-1,1,1,1,-3,2,-1,-1,2,2,-2,-2,1,-1,1,1,-2,2,-1,-1,3,3,-2,-2,-2},{3,-1,-1,3,3,-3,-2,-2,1,-1,1,-1,3,-1,-1,-1,2,2,-2,-2,3,3,3,-3,-3,-3}};
    private static int[] rotorReflector = {4,3,7,1,0,8,11,2,5,12,14,6,9,18,10,17,20,15,13,22,16,24,19,25,21,23};
    public static void main(String args[]){
        String input = "";
        String output = "";
        rotorpos[0] = 'g';          //Sample Input
        rotorpos[1] = 't';          //Sample Input
        rotorpos[2] = 'c';          //Sample Input
        input = "sample text";      //Sample Input
        input = input.toUpperCase();
        rotorInitialiser(rotor, rotorpos);
        rotorMaker();           //rotor[][] at this point is now made of +1's and -1's that can be directly used
        int[][] rotorResult = new int[3][26];
        for(int i = 0; i<26; i++){
            int a = i;
            a += rotor[0][a];
            a += (a>25)?-26:(a<0)?26:0;
            a += rotor[1][a];
            a += (a>25)?-26:(a<0)?26:0;
            a += rotor[2][a];
            a += (a>25)?-26:(a<0)?26:0;
            rotorResult[0][i]= a;
        }
        for(int i = 0; i<26; i++)                   //rotor result will have reflected character in the second row of the array
            rotorResult[1][i] = rotorReflector[rotorResult[0][i]];
        for(int i = 0; i<26; i++)                   //rotor result will have reflected character's traced back location in the third row of the array
            rotorResult[2][i] = rotorSearch(rotorResult, rotorResult[1][i]);
        for(int i =0; i < input.length(); i++){
            if(input.charAt(i) == 32)
                output += " ";
            else
                output += String.valueOf((char)(rotorResult[2][input.charAt(i)-65] + 65));
        }
        rotorResult = null;
        output = output.toLowerCase();
        System.out.println(output);
    }
    private static void rotorInitialiser(int[][] r, char[] rp){             //sets initial value for first letter on each rotor
        r[0][0] = (int)Character.toUpperCase(rp[0]);
        r[1][0] = (int)Character.toUpperCase(rp[1]);
        r[2][0] = (int)Character.toUpperCase(rp[2]);
    }
    private static void rotorMaker(){                                       //completes the rotor from the initial value
        for(int i = 0; i < 3; i++){
            rotor[i][0] = rotor[i][0]-65;
            for(int j = 1; j < 26; j++){
                if(rotor[i][j-1] == (90-65))
                    rotor[i][j] = 0;
                else
                    rotor[i][j] = (rotor[i][j-1] + 1);
            }
        }
        for(int i = 0; i < 3; i++){                                         //replaces the initial value with things that can be used from rotorShift[][]
            for(int j = 0; j < 26; j++)
                rotor[i][j] = rotorShift[i][rotor[i][j]];
        }
    }

    private static int rotorSearch(int[][] result,int a){                   //searches for its other half after the rotorReflector
        for(int i = 0; i<26; i++){
            if (result[0][i] == (a))
                return i;
        }
        return 0;
    }
}
