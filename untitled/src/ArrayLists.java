import java.util.Arrays;

public class ArrayLists<T> {

    private T[] arr;
    private int size = 0;

    public ArrayLists() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    private void expandCapacity() {
        //created a helper method
        if (this.size < arr.length) {
            return;
        }
        int length = arr.length;
        T[] newArray = (T[]) new Object[length*2];

        for (int i = 0; i < size; i++) {
            newArray[i] = this.arr[i];
        }
        this.arr =  newArray;
    }

    public T[] add (T t, int index) {
        expandCapacity();
        size++;
        if (index > size) {
            System.out.println("Error: Index out of range");
        }
        if (index < size) {
            if (size > 0) {
                for (int temp = size-1; temp >= index; temp--) {
                    this.arr[temp + 1] = this.arr[temp];
                }
            }
            arr[index] = t;
        }
        else {
            arr[index] = t;
        }
        return arr;
    }

    public T[] add (T item) {
        if (size < arr.length) {
            this.arr[size++] = item;
        }
        else {
            System.out.println("ArrayList is full. Increasing capacity.");
            expandCapacity();
        }
        return arr;
    }

    public T[] remove(int index) {
        if (index < size) {
            T o = arr[index];
            arr[index] = null;
            int temp = index;
            while (temp < size) {
                arr[temp] = arr[temp+1];
                arr[temp+1] = null;
                temp++;
            }
            size--;
            return arr;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T[] rotate(int steps) {
        // arr[temp] = arr[temp+steps];
        // if [temp+steps] >= size, go back to beginning of array -> "-size"
        T[] rotateArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            T o = arr[i];
            if (i+steps < size) {
                rotateArray[i+steps] = o;
            }
            else if (i+steps >= size) {
                rotateArray[i+steps-size] = o;
            }
        }
        return rotateArray;

//        for (int i = 0; i < size; i++) {
//            T o = arr[i];                               //Stores item to be replaced
//            if (i+steps >= size) {
//                int temp = i+steps-size;
//                T t = arr[temp];                        //Stores item that will be replaced
//                arr[i + steps - size] = o;              //replaces item
//                arr[i] = t;                             //replaces stored item
//            }
//            else {
//                int temp = i + steps;
//                T t = arr[temp];            //
//                arr[i + steps] = o;         //
//                arr[i] = arr[temp];         //
//            }
//        }
//        return arr;
    }

    public T get (int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid Position");
        }
        return arr[pos];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String printArray = "";
        for (int temp = 0; temp < size; temp++) {
            if (printArray != "") {
                printArray += ", ";
            }
            printArray += this.arr[temp];
        }
        return "[" + printArray +"]";
    }

    public static void main(String[] args) {
        ArrayLists<Integer> intArray = new ArrayLists<>();
        intArray.add(1);
        System.out.println("Output: " + intArray.toString());
        intArray.add(2);
        System.out.println("Output: " + intArray.toString());
        intArray.add(3);
        System.out.println("Output: " + intArray.toString());
        intArray.add(4);
        System.out.println("Output: " + intArray.toString());
        intArray.add(5);
        System.out.println("Output: " + intArray.toString());
        intArray.add(6);
        System.out.println("Output: " + intArray.toString());
        intArray.add(7, 1);
        System.out.println("Output: " + intArray.toString());
        intArray.add(8, 2);
        System.out.println("Output: " + intArray.toString());
        intArray.remove(2);
        System.out.println("Output: " + intArray.toString());
        System.out.println("Output: " + intArray.get(1));
        System.out.println("Size: " + intArray.size());
        System.out.println("Input: " + intArray.toString());
        System.out.println("Output: " + Arrays.toString(intArray.rotate(2)));
    }
}
