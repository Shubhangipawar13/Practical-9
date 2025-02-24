class Practical9 {

// Comparing time of Iterative and Recursive method of factorial calculation 
 int[] random_num(int size){
 	int[] random_number_array = new int[size];
 	for(int i=0; i<size; i++){
 		random_number_array[i] = (int)((System.nanoTime()%100)+1);
 	}
 	return random_number_array;
 }
 
 
public static long factorial1(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
    
public static long factorial2(int num){
	if(num<=1){
		return 1;
	}
	return num*factorial2(num-1);
}    

public static long avg_timefor_fact1(int[] random_number_array) {
        long total_time = 0; 

        for (int i = 0; i < random_number_array.length; i++) {
            long start_time = System.nanoTime();  
            long fact = factorial1(random_number_array[i]);  
            long end_time = System.nanoTime();  
            total_time += (end_time - start_time); 
        }

        long avg_time = total_time / random_number_array.length; 
        return avg_time;
    }
    
public static long avg_timefor_fact2(int[] random_number_array) {
        long total_time = 0; 

        for (int i = 0; i < random_number_array.length; i++) {
            long start_time = System.nanoTime();  
            long fact = factorial2(random_number_array[i]);  
            long end_time = System.nanoTime();  
            total_time += (end_time - start_time); 
        }

        long avg_time = total_time / random_number_array.length; 
        return avg_time;
    }  
    
public static char Random_Char(long randomValue) {
        int ascii_value = (int) (randomValue % 52); 
        if(ascii_value < 26){
        return (char) (ascii_value + 65);
        }
        return (char) (ascii_value + 71);
    }
    
    
public static String random_string(int size){
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < size; i++) {
            long randomValue = System.nanoTime();
            randomString.append(Random_Char(randomValue));
        }

        return randomString.toString();
}   
     
      

public static void time_takenby_Stringto_concatenate(int size) {
    String str = random_string(size);
    
    long start_time1 = System.nanoTime();
    String str_concat = str + str;
    long end_time1 = System.nanoTime();
    long String_time_diff = end_time1 - start_time1;
    System.out.println(String_time_diff);
    
    
    StringBuffer sBuff = new StringBuffer(str);
    long start_time2 = System.nanoTime();
    sBuff.append(str);
    long end_time2 = System.nanoTime();
    long StringBuffer_time_diff = end_time2 - start_time2;
    System.out.println(StringBuffer_time_diff);
    
    StringBuilder sBuild = new StringBuilder(str);
    long start_time3 = System.nanoTime();
    sBuild.append(str);
    long end_time3 = System.nanoTime();
    long StringBuilder_time_diff = end_time3 - start_time3;
    System.out.println(StringBuilder_time_diff);
    
    // Determining the most efficient method
    if (String_time_diff < StringBuffer_time_diff && String_time_diff < StringBuilder_time_diff) {
        System.out.println("String is more efficient");
    } 
    else if (StringBuffer_time_diff < String_time_diff && StringBuffer_time_diff < StringBuilder_time_diff) {
        System.out.println("StringBuffer is more efficient");
    } 
    else {
        System.out.println("StringBuilder is more efficient");
    }
}


}
