// Ne rien écrire ici

public static void countingSheeps(int N) {
        String num;
        int Nbis = N;
        int liste[] = new int[10];
        liste[0] = -1;

        for (int i = 1; i>0; i++){
        Nbis = N*i;
        num = String.valueOf(Nbis);

        for (int j = 0; j<num.length(); j++){
        liste[num.charAt(j) - '0'] = num.charAt(j) - '0';
        }
        if (Nbis == N*(i-1)){
        System.out.println("INSOMNIE");
        break;
        }
        else if(liste[0]==0 && liste[1]==1 && liste[2]==2 && liste[3]==3 && liste[4]==4 && liste[5]==5 && liste[6]==6 && liste[7]==7 && liste[8] == 8){
        System.out.println(Nbis);
        break;
        }
        }
        }