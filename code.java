public class FindPeaks {

   public static int[][] findPeaks(int[] x){
       int N = x.length;
       int[][] peaksAndLocations = new int[2][N];
      
       int j=0; // counter for peaks and locations
      
       // case for when data has only one element, it's a peak by default
       if(N==1){  
           peaksAndLocations[0][j] = x[0]; //peak
           peaksAndLocations[1][j] = 0; // location
          
       }else{
  
           // checking if first element is a peak
       if(x[0]>x[1]){
           peaksAndLocations[0][j] = x[0];
           peaksAndLocations[1][j] = 0;
          
           j++;
       }

       // case when the peaks lie in the middle of the array data
       for(int i=1;i<N-1;i++){  
           if((x[i]>x[i-1])&&(x[i]>x[i+1])){ // compare element with next element before and after
               peaksAndLocations[0][j] = x[i]; // peak
               peaksAndLocations[1][j] = i; // location
              
               j++;
           }
       }
      
       // check if last element is a peak
       if(x[N-1]>x[N-2]){
           peaksAndLocations[0][j] = x[N-1]; // peak
           peaksAndLocations[1][j] = N-1; // location
           j++;
       }
      
       }
  
       // trimming the extra zeros in the peaksAndLocations array  
       int numberOfPeaks = j;
       int[][] actualPeaksAndLocations = new int[2][numberOfPeaks]; // sized to the actual number of peaks and/or locations
      
       for(int i=0;i<numberOfPeaks;i++){ // up to numberOfPeaks to ignore extra zeros
           actualPeaksAndLocations[0][i] = peaksAndLocations[0][i];
           actualPeaksAndLocations[1][i] = peaksAndLocations[1][i];
  
       }
      
       return actualPeaksAndLocations;
      
   }
  
  

   public static void main(String[] args) {

       //int[] data = {2,3,5,2,7,8,3,9,0,1};
       //int[] data = {2,2,2};
       //int[] data = {3,2,3};
       //int[] data = {3};
       int[] data = {3,6,7,5,3,-1,1};
      
       int peaks[][] = findPeaks(data);
       int n = peaks[0].length; // number of peaks and/or locations returned
  
       System.out.print("data: ");
       for(int i=0;i<data.length;i++)
System.out.print(data[i] + " ");
      
         
       // displaying results in table form
       System.out.println("\n\npeak location");
       for(int i=0;i<n;i++)
System.out.println(peaks[0][i]+"\t"+peaks[1][i]);

   }

}

