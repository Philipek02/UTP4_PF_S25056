/**
 *
 *  @author Pańczak Filip S25056
 *
 */

package zad1;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Anagrams {
    String path;
    List<List<String>> listOfLists;
    List<String> wordList;

    public Anagrams(String path) {
        this.path = path;
    }

    public List<List<String>> getSortedByAnQty() {
          //  List<List<String>> tempListOfLists = new ArrayList<>();
        listOfLists = new ArrayList<>();
        try {
            List<String> lineList = new ArrayList<>(Files.readAllLines(Paths.get(path)));
            wordList = new ArrayList<>();
            for (String s : lineList) {
                wordList.addAll(Arrays.asList(s.split(" ")));
            }

            //FINDING ANAGRAMS
            HashMap<String, List<String>> map = new HashMap<>();

            for (String slowo :
                    wordList) {
                char[] litery = slowo.toCharArray();
                Arrays.sort(litery);
                String tempWord = new String(litery);

                if (map.containsKey(tempWord)) {
                    map.get(tempWord).add(slowo);

                } else {
                    List<String> words = new ArrayList<>();
                    words.add(slowo);
                    map.put(tempWord, words);
                }
            }
            List<String> values;
            //KOPIOWANIE Z HASHMAPY DO LISTY
            for (String s : map.keySet()) {
                values = map.get(s);
                listOfLists.add(values);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        //BUBBLE SORT
        int n = listOfLists.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listOfLists.get(j).size() < listOfLists.get(j + 1).size()) {
                    List<String> temp = listOfLists.get(j);
                    listOfLists.set(j, listOfLists.get(j + 1));
                    listOfLists.set(j + 1, temp);
                }
            }
        }
        return listOfLists;
    }

    public String getAnagramsFor(String word) {
        boolean flag = false;
        for (String slowo5:
             wordList) {
            if (slowo5.equals(word)) {
                flag = true;
                break;
            }
        }
        if (!flag)return word + ": null";

        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String temp = new String(chars);

        ArrayList<String> list = new ArrayList<>();
        for (String slowo:
             wordList) {
            char[] tempChars = slowo.toCharArray();
            Arrays.sort(tempChars);
            String tempSlowo = new String(tempChars);
            if (tempSlowo.equals(temp)){
                list.add(slowo);
            }
        }
        list.removeIf(slowo -> slowo.equals(word));


        return word + ": " + list;
    }
}
