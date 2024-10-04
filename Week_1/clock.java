class Clock{
    public int hours, minutes, seconds;
    public void setTime(int h, int m, int s){
        hours = ((h>=0 && h<24) ? h : 0);
        minutes = ((m>=0 && m<60) ? m : 0);
        seconds = ((s>=0 && s<60) ? s : 0);
    }
    public void print(){
        System.out.println("Current time: " + hours + ":" + minutes + ":" + seconds);
    }
}

class PublicClock{
    public static void main(String[] args){
        Clock c1 = new Clock();
        c1.setTime(10, 20, 30);
        if(c1.hours == 0 || c1.minutes == 0 || c1.seconds == 0){
            System.out.println("Invalid input time");
        }else
            c1.print();

        Clock c2 = new Clock();
        c2.setTime(25, 30, 50);
        if(c2.hours == 0 || c2.minutes == 0 || c2.seconds == 0){
            System.out.println("Invalid input time");
        }else
            c2.print();

        Clock c3 = c2;
        c3.setTime(15, 40, 50);
        if(c3.hours == 0 || c3.minutes == 0 || c3.seconds == 0){
            System.out.println("Invalid input time");
        }else
            c3.print();
    }
}