package mergesort;

import java.util.Scanner;

class MergeSort {
    
    public static void mergeSort(String[]a, int low, int high){
        int N = high - low;
        if(N <= 1){
            return;
        }
        int mid = low + (N / 2);
        
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        
        String[] temp = new String[N];
        int i = low;
        int j = mid;
        for(int k = 0; k < N; k++){
            if(i == mid){
                temp[k] = a[j++];
            }else if(j == high){
                temp[k] = a[i++];
            }else if(a[j].compareTo(a[i]) < 0){
                temp[k] = a[j++];
            }else{
                temp[k] = a[i++];
            }
        }
        for(int k = 0; k < N; k++){
            a[low + k] = temp[k];
        }
    }
    
    public static void mainProgram(){
        
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        
        if(testCase > 100){
            System.exit(0);
        }
        
        for(int i = 0; i < testCase; i++){
            int jumlahString = s.nextInt();
            
            if((jumlahString <= 1) || (jumlahString >= 50000)){
                mainProgram();
            }
            
            int result = jumlahString;
            String kataK[] = new String[jumlahString];
            for(int j = 0; j < jumlahString; j++){
                kataK[j] = s.next();
                if(kataK[j].length() != 10){
                    mainProgram();
                }
            }
            mergeSort(kataK, 0, kataK.length);
            for(int j = 0; j <kataK.length; j++){
                System.out.println(kataK[j]);
            }
        }
       
    }
    
    public static void main(String args[]){
        mainProgram();
    }
    
}
