import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

class Patterns {


    public void TopRightAngle(int len) {
        int[] count = {1};
        IntStream.rangeClosed(1, len).forEach(i -> {
            IntStream.rangeClosed(1, i).forEach(j -> {
                if (count[0] < 10) {
                    System.out.print(count[0] + "  ");
                    count[0]++;
                } else {
                    System.out.print(count[0] + " ");
                    count[0]++;
                }

            });
            System.out.println();
        });
    }

    public void TopLeftAngle(int len) {
        int[] count = {1};
//        for (int i = 1; i <= len; i++) {
//            for (int j = 1; j <= len - i; j++) {
//                System.out.print("   ");
//            }
//            for (int k = 1; k <= i; k++) {
//                if (count < 10) {
//                    System.out.print("  " + count);
//
//                } else {
//                    System.out.print(" " + count);
//                }
//                count++;
//            }
//            System.out.println();
//        }
        IntStream.rangeClosed(1, len).forEach(i -> {
            IntStream.rangeClosed(1, i).forEach(k -> {
                if (count[0] < 10) {
                    System.out.print("  " + count[0]);
                } else {
                    System.out.print(" " + count[0]);
                }
                count[0]++;
            });
            System.out.println();
        });


    }

    public void BottomRightAngle(int len) {
//        int count = 1;
//        for (int i = len; i >= 1; i--) {
//            for (int j = len; j > i; j--) {
//                System.out.print("   ");
//            }
//            for (int k = 1; k <= i; k++) {
//                if (count < 10) {
//                    System.out.print("  " + count);
//
//                } else {
//                    System.out.print(" " + count);
//                }
//                count++;
//            }
//            System.out.println();
//        }
        int[] count = {1};
        IntStream.iterate(len, i -> i - 1).limit(len).forEach(i -> {
            IntStream.rangeClosed(1, len - i).forEach(j -> System.out.print("   "));
            IntStream.rangeClosed(1, i).forEach(k -> {
                if (count[0] < 10) {
                    System.out.print("  " + count[0]);
                } else {
                    System.out.print(" " + count[0]);
                }
                count[0]++;
            });

            System.out.println();
        });
    }

    public void BottomLeftAngle(int len) {
        int count = 1;
        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (count < 10) {
                    System.out.print(count + "   ");

                } else {
                    System.out.print(count + "  ");
                }
                count++;
            }
            System.out.println();
        }
    }

    public void TopTriangle(int len) {
        int count = 1;
        for (int i = 1; i <= len; i++) {
            for (int k = len; k >= i; k--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                if (count < 10) {
                    System.out.print("   " + count);

                } else {
                    System.out.print("  " + count);
                }
                count++;
            }
            System.out.println();
        }
    }

    public void BottomTriangle(int len) {
        int count = 1;
        for (int i = len; i >= 1; i--) {
            for (int k = len; k >= i; k--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                if (count < 10) {
                    System.out.print(count + "    ");

                } else {
                    System.out.print(count + "  ");
                }
                count++;
            }
            System.out.println();
        }
    }

    public void Hollow(int len) {
        int count = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if ((i == 1 || i == len) || (j == 1 || j == len)) {
                    if (count < 10) {
                        System.out.print(count + "  ");

                    } else {
                        System.out.print(count + " ");
                    }
                    count++;
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public void Rhombus(int numRows) {
        int count = 1;
        if (numRows % 2 == 0) {
            numRows++;
        }
        int spaces = numRows / 2;
        int stars = 1;
        for (int i = 1; i <= numRows; i++) {

            for (int j = 1; j <= spaces; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= stars; j++) {
                if (count < 10) {
                    System.out.print("  " + count);

                } else {
                    System.out.print(" " + count);
                }
                count++;
            }
            System.out.println();
            if (i <= numRows / 2) {
                spaces--;
                stars += 2;
            } else {
                spaces++;
                stars -= 2;
            }
        }
    }
}

public class PatternClass {
    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        Patterns p = new Patterns();
        try {
            System.out.print("Enter length of the Pattern : ");
            int len = sc.nextInt();
            System.out.print("Choose the Pattern : ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("<--TopRightAngle-->");
                    p.TopRightAngle(len);
                    break;
                case 2:
                    System.out.println("<--TopLeftAngle-->");
                    p.TopLeftAngle(len);
                    break;
                case 3:
                    System.out.println("<--BottomRightAngle-->");
                    p.BottomRightAngle(len);
                    break;
                case 4:
                    System.out.println("<--BottomLeftAngle-->");
                    p.BottomLeftAngle(len);
                    break;
                case 5:
                    System.out.println("<--Top Triangle-->");
                    p.TopTriangle(len);
                    break;
                case 6:
                    System.out.println("<--Bootom Triangle-->");
                    p.BottomTriangle(len);
                    break;
                case 7:
                    System.out.println("<--Hollow-->");
                    p.Hollow(len);
                    break;
                case 8:
                    System.out.println("<--Rhombus-->");
                    p.Rhombus(len);
                    break;
                default:
                    System.out.println("No pattern here");
            }
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }
}
