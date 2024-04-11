package com.magicvet;

import com.magicvet.component.ApplicationRunner;
import java.util.Scanner;

public class Main {
       public static Scanner SCANNER;

        public Main() {
        }

        public static void main(String[] args) {
            ApplicationRunner runner = new ApplicationRunner();
            runner.run();
        }

        static {
            SCANNER = new Scanner(System.in);
        }
    }

