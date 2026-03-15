import java.util.Arrays;

public class Fcfs {
    public static int currentTime = 0; // to keep track of current timeline
    public static int idleTime = 0;
    public static int[] executed = new int[10];  // max 10 process at a time
    public static int execIndex = 0;

    //for gantt Chart
    static String[] ganttProcess = new String[20];
    static int[] ganttTime = new int[20];
    static int ganttIndex = 0;

    static class Process{ // made it static to be able to use in main
        int id, arrivalTime, execTime;
        int turnAroundTime, waitingTime;

        public Process(int id, int arrivalTime, int execTime){ //constructor
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.execTime = execTime;
        }

        public void execute(int OverheadTime){  // modifies the current timeline
            if (OverheadTime != 0)
                currentTime += OverheadTime;

            if(this.arrivalTime > currentTime){   // if there is a gap in the arr. time and last exec time
                ganttProcess[ganttIndex] = "Idle";
                ganttTime[ganttIndex++] = currentTime;

                idleTime += arrivalTime - currentTime;
                currentTime += arrivalTime - currentTime;
            }
            //gant update
            ganttProcess[ganttIndex] = "P" + (id+1);
            ganttTime[ganttIndex++] = currentTime;
            
            currentTime += this.execTime;
            System.out.println("\u001B[32m" + " > > > Now Running P"+ (id+1) + " AT: " + arrivalTime + ", ET: " + execTime + ", Time Now " + currentTime + "\u001B[0m");

            executed[execIndex++] = this.id;

            //calculating tat and waiting time
            turnAroundTime = currentTime - this.arrivalTime;
            waitingTime = turnAroundTime - execTime;
        }
    }

    public static boolean isExecuted(int index){
        for(int i=0; i<execIndex; i++){
            if(executed[i] == index)
                return true;
        }
        return false;
    }

    public static int currentChoice(Process[] processArray){
        int chosenIndex = -1;
        
        for(int i = 0; i<processArray.length; i++){
            if(isExecuted(i)) 
                continue;

            if (chosenIndex == -1) {
                chosenIndex = i;
                continue;
            }

            if(processArray[i].arrivalTime < processArray[chosenIndex].arrivalTime){
                chosenIndex = i;
            }

            if(processArray[i].arrivalTime == processArray[chosenIndex].arrivalTime && processArray[i].id != processArray[chosenIndex].id){
                if (processArray[i].id < processArray[chosenIndex].id) {
                    chosenIndex = i;
                }
            }
        }

        return chosenIndex;
    }

    public static void printGantt(){

    System.out.println("\u001B[35m" +  "\nGantt Chart:");

    for(int i=0;i<ganttIndex;i++){
        System.out.print("| " + ganttProcess[i] + " ");
    }
    System.out.println("|");

    for(int i=0;i<=ganttIndex;i++){

        if(i < ganttIndex && "Idle".equals(ganttProcess[i])){
            System.out.print(ganttTime[i] + "      ");
        } else{
            System.out.print(ganttTime[i] + "    ");
        }

    }

    System.out.println("\u001B[0m" + ""); // reset the color and newline
    }

    public static void run(Process[] p, int OverheadTime){
        for(int i=0; i<p.length; i++){
            p[currentChoice(p)].execute(OverheadTime);         
        }
        ganttTime[ganttIndex] = currentTime;
    }

    public static void main(String[] args){
        Process p[] = new Process[5];
        Arrays.fill(executed, -1);

        p[0] = new Process(0, 3, 4);
        p[1] = new Process(1, 5, 3);
        p[2] = new Process(2, 0, 2);
        p[3] = new Process(3, 5, 1);
        p[4] = new Process(4, 4, 3);

        run(p,0);
        printGantt();

        float avgTat = 0, avgWaitingTime = 0;

        for(Process px: p){
            avgTat += px.turnAroundTime;
            avgWaitingTime += px.waitingTime;
        }
        avgTat/=p.length;
        avgWaitingTime/=p.length;

        System.out.println("\nAvg TAT for the processes is " + "\u001B[32m" + avgTat + "\u001B[0m" +" units");
        System.out.println("Average Waiting Time is " + "\u001B[32m" + avgWaitingTime + "\u001B[0m" + " units\n");
    }
}
