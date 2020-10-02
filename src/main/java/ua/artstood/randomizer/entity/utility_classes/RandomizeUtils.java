package ua.artstood.randomizer.entity.utility_classes;


import java.util.ArrayList;
import java.util.List;

public interface RandomizeUtils {

    static int rand(int min, int max){
        return (int) ((Math.random() * (max-min+1)) + min) ;
    }

    static int dice(int edgeNumber, int amountOfThrows){
        int answ = 0;
        for(int i =0; i<amountOfThrows; i++){
            answ+=rand(1,edgeNumber);
        }
        return answ;
    }

    static int statRoll(int edgeNumber, int amountOfThrows) {
        int min = edgeNumber;
        int answ = 0;
        for (int i = 0; i < amountOfThrows; i++) {
            int num = dice(6, 1);
            answ += num;
            if (num < min) {
                min = num;
            }
        }
        return answ - min;
    }

    static Pair<Integer, Integer> generateTwoIndexes(int size){
        int first  =rand(0,size-1);
        int second;
        do{
            second = rand(0,size-1);
        }while (second == first);

        return new Pair<>(first, second);
    }
    static List<String> getTwoRandomStrings(List<String> source){
        List<String> answer = new ArrayList<>();
        Pair<Integer, Integer> indexes = generateTwoIndexes(source.size());
        answer.add(source.get(indexes.first));
        answer.add(source.get(indexes.second));
        return answer;
    }

    static String getRandomString(List<String> list){
        return list.get(rand(0,list.size()-1));
    }


}
