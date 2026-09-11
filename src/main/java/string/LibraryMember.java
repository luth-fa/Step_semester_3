package string;

public class LibraryMember {

    static class BrokenLibraryMember {

        static String name;
        static String memberId;
        static int booksIssued;

        BrokenLibraryMember(String name, String memberId, int booksIssued) {
            BrokenLibraryMember.name = name;
            BrokenLibraryMember.memberId = memberId;
            BrokenLibraryMember.booksIssued = booksIssued;
        }

        void printDetails() {
            System.out.println(name + " " + memberId + " " + booksIssued);
        }
    }


    static class FixedLibraryMember {

        String name;
        String memberId;
        int booksIssued;

        static String libraryName = "SRM Library";
        static int memberCount = 0;

        FixedLibraryMember(String name, int booksIssued) {

            this.name = name;
            this.booksIssued = booksIssued;

            memberCount++;
            this.memberId = "LM-100" + memberCount;
        }

        void printMemberCard() {

            System.out.println("Name: " + name);
            System.out.println("Member ID: " + memberId);
            System.out.println("Books Issued: " + booksIssued);
            System.out.println("Library: " + libraryName);
            System.out.println();
        }

        static void printTotalMembers() {
            System.out.println("Total Members: " + memberCount);
        }
    }


    public static void main(String[] args) {

        System.out.println("Broken Version:");

        BrokenLibraryMember member1 =
                new BrokenLibraryMember("Aditi", "LM-1001", 2);

        BrokenLibraryMember member2 =
                new BrokenLibraryMember("Rohan", "LM-1002", 3);

        member1.printDetails();
        member2.printDetails();


        System.out.println();
        System.out.println("Fixed Version:");

        FixedLibraryMember member3 =
                new FixedLibraryMember("Aditi", 2);

        FixedLibraryMember member4 =
                new FixedLibraryMember("Rohan", 3);

        member3.printMemberCard();
        member4.printMemberCard();

        FixedLibraryMember.printTotalMembers();
    }

    
    
}