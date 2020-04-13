public class HW6_3 {
    public boolean check_Array(int[] array){
        boolean result = true;
        int countOne = 0;
        int countFor = 0;

        for (int element:array) {
            if (element == 1 ){
                countOne++;
            }
            else if( element == 4){
                countFor++;
            }
        }
        if(countOne == 0 || countFor == 0 || (countFor + countOne) != array.length){
            result = false;
        }

        return result;

    }
    public static void main(String[] args) {
        int [] a=new int[]{ 1, 1, 1, 4, 4, 1, 4, 3 };
        HW6_3  lesson6_3 = new HW6_3();
        System.out.println(lesson6_3.check_Array(a));
    }
}
