package ashwini;

import java.util.Scanner;

public class Questions {
    private String Question;
    private String choices;
    private String answer;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        this.Question = question;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String in;
        System.out.println("Enter your name : ");
        String name;
        name = scan.nextLine();
        int c = 0;

        Questions ques_1 = new Questions();
        ques_1.setQuestion("Who is the president of USA? ");
        ques_1.setChoices("1.trump " +
                "2.obama " +
                "3.george " +
                "4.justin");
        ques_1.setAnswer("1");
        System.out.println(ques_1.getQuestion());
        System.out.println(ques_1.getChoices());


        Questions ques_2 = new Questions();
        ques_2.setQuestion("Who is the president of India? ");
        ques_2.setChoices("1.abdul " +
                "2.ashwini " +
                "3.george " +
                "4.pranab");
        ques_2.setAnswer("4");
        System.out.println(ques_2.getQuestion());
        System.out.println(ques_2.getChoices());


        Questions ques_3 = new Questions();
        ques_3.setQuestion("Who is the president of Canada? ");
        ques_3.setChoices("1.abdul " +
                "2.ashwini " +
                "3.justin " +
                "4.pranab");
        ques_3.setAnswer("3");
        System.out.println(ques_3.getQuestion());
        System.out.println(ques_3.getChoices());


        Questions ques_4 = new Questions();
        ques_4.setQuestion("Who is the president of Australlia? ");
        ques_4.setChoices("1.abdul " +
                "2.ashwini " +
                "3.george " +
                "4.malcolm");
        ques_4.setAnswer("4");
        System.out.println(ques_4.getQuestion());
        System.out.println(ques_4.getChoices());


        Questions ques_5 = new Questions();
        ques_5.setQuestion("Who is the president of argentina? ");
        ques_5.setChoices("1.abdul " +
                "2.macri " +
                "3.george " +
                "4.pranab");
        ques_5.setAnswer("2");
        System.out.println(ques_5.getQuestion());
        System.out.println(ques_5.getChoices());

        System.out.println("Enter your answer for the first question : ");
        String answer = scan.nextLine();
        if(answer.equals(ques_1.getAnswer())) {
            System.out.println("Your answer is correct ");
            c++;
        }
        else {
            System.out.println("Your answer is wrong ");
        }
        System.out.println("The correct answer is : " + ques_1.getAnswer());

        System.out.println("Enter your answer for the second question : ");
        String answer1 = scan.nextLine();
        if(answer1.equals(ques_2.getAnswer())) {
            System.out.println("Your answer is correct ");
            c++;
        }
        else {
            System.out.println("Your answer is wrong ");
        }
        System.out.println("The correct answer is : " + ques_2.getAnswer());

        System.out.println("Enter your answer for the third question : ");
        String answer2 = scan.nextLine();
        if(answer2.equals(ques_3.getAnswer())) {
            System.out.println("Your answer is correct ");
            c++;
        }
        else {
            System.out.println("Your answer is wrong ");
        }
        System.out.println("The correct answer is : " + ques_3.getAnswer());

        System.out.println("Enter your answer for the fourth question : ");
        String answer3 = scan.nextLine();
        if(answer3.equals(ques_4.getAnswer())) {
            System.out.println("Your answer is correct ");
            c++;
        }
        else {
            System.out.println("Your answer is wrong ");
        }
        System.out.println("The correct answer is : " + ques_4.getAnswer());

        System.out.println("Enter your answer for the fifth question : ");
        String answer4 = scan.nextLine();
        if(answer4.equals(ques_5.getAnswer())) {
            System.out.println("Your answer is correct ");
            c++;
        }
        else {
            System.out.println("Your answer is wrong ");
        }
        System.out.println("The correct answer is : " + ques_5.getAnswer());

        System.out.println(name + " got " + c + " out of 5");
        if(c >= 3) {
            System.out.println("You have passed the quiz");
        }else {
            System.out.println("Work hard! failed");
        }

    }

}


