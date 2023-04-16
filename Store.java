import java.util.Scanner;

class MUTS{
    char Zone;
    int TimberID;
    String Kind;
    float Weight;
    float Height;
    int Quantity;
    int Price;

    MUTS(){
        Zone = 'P';
        TimberID = 0;
        Kind = "NILL";
        Weight = 0;
        Height = 0;
        Quantity = 0;
        Price = 0;
    }

    void nrecord(MUTS[] a, int b){
        Scanner record = new Scanner(System.in);
        Scanner cr = new Scanner(System.in);
        Scanner k = new Scanner(System.in);
        cr.useDelimiter("");
        System.out.println("\nEnter Zone: ");
        Zone = cr.next().charAt(0);
        System.out.println("Enter Timber ID: ");
        TimberID = record.nextInt();
        for(int i=0;i<b;i++){
            if(TimberID == a[i].TimberID){
                System.out.println("TimberID Already Exists!");
                nrecord(a, b);
            }
        }
        System.out.println("Enter Timber Kind: ");
        Kind = k.nextLine();
        System.out.println("Enter Timber Weight: ");
        Weight = record.nextFloat();
        System.out.println("Enter Timber Height: ");
        Height = record.nextFloat();
        System.out.println("Enter Timber Quantity: ");
        Quantity = record.nextInt();
        System.out.println("Enter Timber Price: ");
        Price = record.nextInt();
        System.out.println("Record Added Succesfully !");
    }

    void display(MUTS[] a, char b){
        System.out.println("\nRecords for Zone " + b + ":");
        int check=0;
        for(int i=0;i<a.length;i++){
            if(a[i].Zone == b){
                System.out.println("TimberID: " + a[i].TimberID + "\nTimber Kind: " + a[i].Kind + "\nTimber Weight: " + a[i].Weight + "\nTimber Height: " + a[i].Height + "\nTimber Quantity: " + a[i].Quantity + "\nTimber Price: " + a[i].Price + "\n");
                check = 1;
            }
        }
        if(check==0){
            System.out.println("No Records Found!\n");
        }
    }

    void pdisplay(MUTS[] a, String b){
        int match = 0;
        for(int i=0;i<a.length;i++){
            if(a[i].Kind.equals(b)){
                System.out.println("\nTimberID: " + a[i].TimberID + "\nTimber Kind: " + a[i].Kind + "\nTimber Weight: " + a[i].Weight + "\nTimber Height: " + a[i].Height + "\nTimber Quantity: " + a[i].Quantity + "\nTimber Price: " + a[i].Price + "\n");
                match = 1;
            }
        }
        if(match==0){
            System.out.println("Kind Not Found!!\n");
        }
    }

    void analysis(MUTS[] a){
        int qcheck = 0;
        System.out.println("\nRecords Having Quantity Less Than 100:");
        for(int i=0;i<a.length;i++){
            if(a[i].Quantity < 100 && a[i].TimberID !=0){
                System.out.println("\nTimberID: " + a[i].TimberID + "\nTimber Kind: " + a[i].Kind + "\nTimber Weight: " + a[i].Weight + "\nTimber Height: " + a[i].Height + "\nTimber Quantity: " + a[i].Quantity + "\nTimber Price: " + a[i].Price + "\n");
                qcheck = 1;
            }
        }
        if(qcheck == 0){
            System.out.println("No Record Found!\n");
        }
    }

    void sales(MUTS[] a, int b, int c){
        for(int i=0;i<a.length;i++){
            if(a[i].TimberID == b){
                if(a[i].Quantity < c){
                    System.out.println("Quantity Exceeds the Available Stock!\n");
                }
                else{
                    a[i].Quantity = a[i].Quantity - c;
                    System.out.println("Quantity Sold!\n");
                    System.out.println("Updated Record:\nTimberID: " + a[i].TimberID + "\nTimber Kind: " + a[i].Kind + "\nTimber Weight: " + a[i].Weight + "\nTimber Height: " + a[i].Height + "\nTimber Quantity: " + a[i].Quantity + "\nTimber Price: " + a[i].Price + "\n");
                }
            }
        }
    }

    void delete(MUTS[] a, int b){
        int loc = 10;
        for(int i=0;i<a.length;i++){
            if(a[i].TimberID == b){
                loc = i;
            }
        }
        for(int i=loc;i<a.length-1;i++){
            a[i] = a[i+1];
        }
        a[a.length-1].TimberID = 0;
        a[a.length-1].Zone = 'P';
        a[a.length-1].Kind = "NILL";
        a[a.length-1].Weight = 0;
        a[a.length-1].Height = 0;
        a[a.length-1].Quantity = 0;
        a[a.length-1].Price = 0;
        System.out.println("Record Deleted !\n");
    }

    void qupdate(MUTS[] a, int b, int c){
        for(int i=0;i<a.length;i++){
            if(a[i].TimberID == b){
                a[i].Quantity = c;
            }
        }
        System.out.println("Record Quantity Updated !\n");    
    }

    void pupdate(MUTS[] a, int b, int c){
        for(int i=0;i<a.length;i++){
            if(a[i].TimberID == b){
                a[i].Price = c;
            }
        }
        System.out.println("Record Price Updated !\n");    
    }
}

class Store{
    public static void main(String[] args) {
        MUTS[] obj = new MUTS[10];
        for(int i=0;i<obj.length;i++){
            obj[i] = new MUTS();
        }
        int option = 0;
        while(option != 8){
            Scanner sc = new Scanner(System.in);
            Scanner c = new Scanner(System.in);
            c.useDelimiter("");
            System.out.println("Main Menu");
            System.out.println("1. Add a New Timer Record\n2. Display All Records for a Zone\n3. Display a Particular Record (By Kind)\n4. Analysis of Record Level\n5. Sales Update Report\n6. Delete a Timber Record\n7. Update a Timber Record\n8. Exit");
            System.out.println("Please Enter Your Choice: ");
            option = sc.nextInt();

            if(option == 1){
                for(int i=0;i<obj.length;i++){
                    if(obj[i].TimberID == 0){
                        obj[i].nrecord(obj, i);
                        break;
                    }
                }
            }
            else if(option == 2){
                char Z;
                System.out.println("Enter Zone: ");
                Z = c.next().charAt(0);
                obj[0].display(obj, Z);
            }
            else if(option == 3){
                String K;
                Scanner kd = new Scanner(System.in);
                System.out.println("Enter Kind: ");
                K = kd.nextLine();
                obj[0].pdisplay(obj, K);
            }
            else if(option == 4){
                obj[0].analysis(obj);
            }
            else if(option == 5){
                int Q, I;
                System.out.println("Enter TimberID: ");
                I = sc.nextInt();
                System.out.println("Enter Quantity: ");
                Q  = sc.nextInt();
                obj[0].sales(obj, I, Q);
            }
            else if(option == 6){
                int D;
                System.out.println("Enter TimberID to be Deleted: ");
                D = sc.nextInt();
                obj[0].delete(obj, D);
            }
            else if(option == 7){
                int U, O, Q, P;
                System.out.println("Enter TimberID to be Updated: ");
                U = sc.nextInt();
                System.out.println("Select Update:\n1. Quantity\n2. Price\nYour Choice:");
                O = sc.nextInt();
                if(O == 1){
                    System.out.println("Enter New Quantity: ");
                    Q = sc.nextInt();
                    obj[0].qupdate(obj, U, Q);
                }
                else if(O == 2){
                    System.out.println("Enter New Price: ");
                    P = sc.nextInt();
                    obj[0].pupdate(obj, U, P);
                }
                else{
                    System.out.println("Invalid Option Entered!\n");
                }
            }
            else if(option == 8){
                System.out.println("\nProgram Terminated !");
            }
            else{
                System.out.println("Invalid Option Entered !");
            }
        }
    }
}