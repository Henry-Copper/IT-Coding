import java.util.ArrayList;

public class RemoveItems {

    public static void removeItemsFromList(ArrayList<String> list, int... itemsToRemove){
        for (int index : itemsToRemove){
            list.remove(index);
        }
    }


}
