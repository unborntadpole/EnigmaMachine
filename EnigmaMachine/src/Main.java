public class Main {
    private static String input = "";
    private static String output = "";
    private static char[] rotorpos = new char[3];
    private static char[][] rotor = new char[3][26];
    private static int[][] rotorShift = {{2,2,2,-3,-3,1,2,-2,-1,2,-1,1,2,-3,3,-2,3,3,-3,-3,2,-3,-1,2,-1,-1},{1,-1,1,1,1,-3,2,-1,-1,2,2,-2,-2,1,-1,1,1,-2,2,-1,-1,3,3,-2,-2,-2},{3,-1,-1,3,3,-3,-2,-2,1,-1,1,-1,3,-1,-1,-1,2,2,-2,-2,3,3,3,-3,-3,-3}};
    private static char[] rotorReflector = {'E','D','H','B','A','I','L','C','F','M','O','G','J','S','K','R','U','P','N','W','Q','Y','T','Z','V','X'};
    //private static String[][] PlugConfig = new String[5][5];
    public static void main(String args[]){
        rotorpos[0] = 'g';        //Sample Input
        rotorpos[1] = 't';       //Sample Input
        rotorpos[2] = 'c';       //Sample Input
        input = "Sample text";  //Sample Input
        //Actual program starts here
        rotorInitialiser(rotor, rotorpos);
        input = input.toUpperCase();
        rotorMaker();
        for(int i =0; i < input.length(); i++){
            if(input.charAt(i) == ' ') {
                output += " ";
                continue;
            }
            int temp = (int)input.charAt(i) - 65;
            temp += rotorShift[0][(int)rotor[0][temp]];
            temp += (temp>=26)?-26:(temp<0)?26:0;
            int ch = (int)rotor[1][temp];
            temp += rotorShift[1][ch-65];
            temp += (temp>=26)?-26:(temp<0)?26:0;
            ch = (int)rotor[2][temp];
            temp =+ rotorShift[2][ch-65];
            temp += (temp>=26)?-26:(temp<0)?26:0;
            temp = (int)rotorReflector[temp]-65;
            

        }
    }
    private static void rotorInitialiser(char[][] r, char[] rp){    //Method checked for errors
        r[0][0] = Character.toUpperCase(rp[0]);
        r[1][0] = Character.toUpperCase(rp[1]);
        r[2][0] = Character.toUpperCase(rp[2]);
    }
    private static void rotorMaker(){                               //Method checked for errors
        for(int i = 0; i < 3; i++){
            for(int j = 1; j < 26; j++){
                if(rotor[i][j-1] == 'Z')
                    rotor[i][j] = 'A';
                else
                    rotor[i][j] = (char)(rotor[i][j-1] + 1);
            }
        }
    }
    private static int rotorReverse(int r, int temp){
        for(int i = 0; i < 26; i++){
            if( == )
                return i;
        }
    }
}








