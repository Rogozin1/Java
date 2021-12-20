package Lesson4;

import java.util.Random;
import java.util.Scanner;

/** "NEW !"  "Д/З - ПОСОБИЕ" (Может использоваться начинающими для пошагового разбора работы программы и усвоения материала)
 */

public class HomeWork4 {

    public static Random random = new Random();               //2 забрали метод random из 3 урока и в стр.188
    public static Scanner scanner = new Scanner(System.in);   //11 для ходилки

    //Map
    public static char[][] map;                               //1    1.32 созд. 2 мерный массив, состоящ. из переменных char
    public static char[][] invisibleMap;                      /**1.1 добавил карту и добавил ловушки*/
    public static int mapWight;                              //1 задали ширину/
    public static int mapHeight;                             //1   высоту
    public static int mapSizeMin = 3;                        //3 т.е размер карты будет случ. генериров 0т3 до 6
    public static int mapSizeMax = 6;                        //3 то же
    public static char empty = '_';                          //2 1.33 создали пустоту(нашего игрока)
    public static char ready = '*';                          //2  место,где игрок был
    public static int levelCount = 0;

    //Player
    public static char player = '@';                         //1 создали игрока
    public static String playerName = "Boris";               //3 задали имя игрока
    public static int playerHP = 100;                        //3 есть здоровье 100
    public static int playerStr = 15;                        //3 сила игрока
    public static int playerX;                               //3 координаты игрока. рандомные
    public static int playerY;                               //3  то же
    public static int playerExp;                             //3 начисляем очки за пройденную ячейку
    public static final int playerMoveUp = 8;                //4 закодировали движение игрока вверх      +  12.7 добавили final
    public static final int playerMoveLeft = 4;              //4 закодировали движение игрока            +  12.7 добавили final
    public static final int playerMoveRight = 6;             //4 закодировали движение игрока            +  12.7 добавили final
    public static final int playerMoveDown = 2;              //4 закодировали движение игрока            +  12.7 добавили final

    //Trap
    public static char trap = 'T';                           //1 создали ловушки,   место
    public static int trapAttack;                            //5  1.42.20  показатель, когда "наступаем" - получаем урон
    public static int trapCount;                             //5   количество ловушек
    public static int trapValueMin = 5;                      //9.5   2.15.05  размер урона               //5 коорд ловушек- на уроке: public static int trapX
    public static int trapValueMax = 15;                     //9.6   2.15.05 размер урона                //5 коорд ловушек- на уроке: public static int trapY


    public static void main(String[] args) {

        while (isPlayerAlive()) {                                               /**2.9 т.к персонаж жив- то теперь буду повышать уровень, печатать,...*/
            ++levelCount;                                                       /**2.10*/
            System.out.println(">>>>> START LEVEL " + levelCount + " <<<<<");   /**3.1    20.05   ...*/
            levelCycle();                                                       /**3.2*/
        }

        System.out.println(">>>>> GAME OVER! " + playerName + " ready " + levelCount + " level(s) <<<<<"); /**3.5-1*/
    }

    public static void levelCycle() {                                           /**1.8 ?(рано,можно позже)-                 //2.8 создание следующего уровня*/
        createMap();                                                 //7  1.56.50 создали карту
        spawnPlayer();                                               //7  1.56.50 поставили игрока
        spawnTrap();                                                 //7  1.56.50 поставили ловушки
                                                                                /**3.4-1 и цикл завершает работу и цикл  while тоже заканчивается - переход на*/
        while (true) {                                               //13.7 чтобы закольцевать программу, чтобы после каждого хода не останавливалась
            showMap();                                               //8.8.
            movePlayer();
                                                                                /**3.3  !! если игрок умер, то 3.4-1              если жив, то 3.4-2*/
            if (!isPlayerAlive()) {                                  //13.8 если игрок погиб - сообщение...
                System.out.println(playerName + " is dead");         //13.9
                break;                                               //14 это первое условие при котором цикл останавливается (игрок погиб)
            }

//            if (isFullMap()) {                                     // 14.3
//                System.out.println(playerName + " win this map");  //14.4 второе условие при котором цикл останавливается (карта кончилась)                             !!! выходит, если прошел
//                break;
//            }
//        }
//        System.out.println("GAME OVER");                           //14.5

            if (!isExistTrap()) {                                            /**1.9 новое: буду заканчивать уровень- когда пройду все ловушки         //3.4-2 и цикл  прерывается, а while не прерывается*/
                System.out.println(playerName + " win this map");            /**2.1*/
                playerExp += 300;                                            /**2.2 прибавил к опыту 300*/
                break;                                                       /**2.3*/
            }
        }
    }


    public static void createMap() {                     //7.1
        mapWight = randomValue(mapSizeMin, mapSizeMax);  //7.6  и дополняем п.7.4
        mapHeight = randomValue(mapSizeMin, mapSizeMax); //7.5
        map = new char[mapHeight][mapWight];             //7.4
        invisibleMap = new char[mapHeight][mapWight];    /**1.2 инициализирую с теми же парметрами, как основная карта*/

        for (int y = 0; y < mapHeight; y++) {           //7.8  положили пустоту в каждую ячейку карты - по 7.10
            for (int x = 0; x < mapWight; x++) {        //7.9
                map[y][x] = empty;                      //7.10
                invisibleMap[y][x] = empty;             /**1.3 повторяю*/
            }
        }

        System.out.println("Map has been created. Map size is " + mapWight + "x" + mapHeight);          //8  2.02.44               7.7
    }

    public static void showMap() {                          //8.1 метод, отвечающий за показ карты
        System.out.println("==========> MAP <==========");  //8.5
        for (int y = 0; y < mapHeight; y++) {               //8.2
            for (int x = 0; x < mapWight; x++) {            //8.3
                System.out.print(map[y][x] + "|");          //8.4
            }
            System.out.println();                           //8.7
        }
        System.out.println("===========================");  //8.6
    }

    public static void spawnPlayer() {                     //7.3
        playerX = randomValue(0, mapWight - 1);            //9    2.07.00
        playerY = randomValue(0, mapHeight - 1);            //9.1
        map[playerY][playerX] = player;                    //9.2 поставить туда игрока
        System.out.println(playerName + " has spawn in [" + (playerX + 1) + ":" + (playerY + 1) + "]");      //9.3 появился игрок на карте
    }

    public static void spawnTrap() {                            //7.2
        trapAttack = randomValue(trapValueMin, trapValueMax);  //9.4 ввели урон в ловушке, ввели 9.5, 9.6
        trapCount = (mapWight + mapHeight) / 2;                //9.7 количество ловушек, потом возвращ.стр.37,38- удаляем их, и вводим п.9.8

        int trapX;                                              //9.8
        int trapY;                                              //9.9

        for (int i = 1; i <= trapCount; i++) {     //10 генерируем ловушки

            do {                                   //10.5 цикл сначала генерирует ячейку, проверяет её, если не пустая(10.6)- начинай сначала
                trapX = random.nextInt(mapWight);  //10.3
                trapY = random.nextInt(mapHeight); //10.4
//            } while (!isEmpty(trapX, trapY));    //10.6
//                map[trapY][trapX] = trap;        //10.7 если все хорошо - ставит ловушку,  потом начинает(цикл fo) то-же для 2-й ловуки
            } while (!isEmpty(map, trapX, trapY) || !isEmpty(invisibleMap, trapX, trapY));  /**1.6 проверяю не стоит ли на клетке игрок, чтобы не поставить под ним ловушку*/
                                                                                            /** и буду смотреть не стои ли уже ловушка     проверяю сразу 2 карты*/
            invisibleMap[trapY][trapX] = trap;                                              /**1.7   ставлю на невидимую карту*/
        }
        System.out.println(trapCount + " trap's has been created. Trap's Attack = " + trapAttack);       //10/8 информац. для игрока
    }

    public static void movePlayer() {   //10.9 Начал ходить 2.40.30

        int currentPlayerX = playerX;   //11.4 временно запомнить где стоял игрок
        int currentPlayerY = playerY;   //11.5 временно запомнить где стоял игрок

        int playerDestination;          //11.1 запомнить положение  направление движения

        do {                           //11.6 даем возможность сходить еще раз, в случае , если при ходе игрок вываливается за границы
            System.out.print("Enter your move: (Up: " + playerMoveUp + " | Down: " + playerMoveDown +           //11.2 говорим игроку, что он может двигаться- влево,    вниз,...
                    " | Left: " + playerMoveLeft + " | Right: " + playerMoveRight + ") >>> ");

            playerDestination = scanner.nextInt();  //11.3 то же далее

            switch (playerDestination) {            //12.5
                case playerMoveUp:                  //...
                    playerY -= 1;
                    break;                         //...
                case playerMoveDown:               //...
                    playerY += 1;
                    break;                         //...
                case playerMoveLeft:               //...
                    playerX -= 1;
                    break;                         //...
                case playerMoveRight:              //...
                    playerX += 1;
                    break;                        //12.6  и идем вверх, добавить final...
            }

        } while (!checkValidMove(currentPlayerX, currentPlayerY, playerX, playerY));  //11.7     + //12.8  где был, куда пошел

        playerMoveAction(currentPlayerX, currentPlayerY, playerX, playerY);           //13.6 после того как сходил

    }

    public static boolean isEmpty(char[][] inputMap, int x, int y) {  /**1.4 раньше просто принимал координаты, теперь- принимает какую-то карту, смотрит какие-то координаты и смотрит-пусто или нет*/
        return inputMap[y][x] == empty;                               /**1.5 ...*/
    }

//    public static boolean isEmpty(int x, int y) {                  //10.1 проверка, что ячейка не занята, н-р игроком, другой ловушкой
//        return map[y][x] == empty;                                 //10.2  если пустая- вернется true, нет - наоборот
//    }
//
//    public static boolean isFullMap() {                            //14.1 второе условие остановки цикла закончилась карта
//        for (int y = 0; y < mapHeight; y++) {                      //14.1
//            for (int x = 0; x < mapWight; x++) {                   //14.1
//                if (map[y][x] == empty) return false;              //14.2 если вся карта заполнена - возвращ.- false, иначе true

    public static boolean isFullMap() {                               /** 2.4 метод будет не нужен*/
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                if (map[y][x] == empty) return false;
            }
        }
        return true;
    }

    public static boolean isExistTrap() {                             /**2.5 добавил метод. проверяет- если ловушек>0 то продолжаем играть, если нет- уровень пройден*/
        return trapCount > 0;
    }

    public static boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {                      //11.8 информ. где был, куда пошел
        if (nextX >= 0 && nextX < mapWight && nextY >= 0 && nextY < mapHeight) {                            //11.9 описали границы, где можно ходить
            System.out.println(playerName + " move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success");  //12 если все хорошо - пошел куда хотел
            return true;
        } else {
            System.out.println(playerName + " move invalid! Please try again!");                            //12.1 если не хорошо - пишет инвалид и возвращаем на исх. позицию
            playerX = pastX;
            playerY = pastY;
            return false;
        }
    }

    public static void playerMoveAction(int pastX, int pastY, int nextX, int nextY) {                       //12.9 организация движения, чтобы где был- поставить готово, куда пошел-проверить, а нет ли ловушки?
        if (invisibleMap[nextY][nextX] == trap) {                                                           //13 если ловушка
            playerHP -= trapAttack;                                                                         //13.1
            trapCount--;                                                                                    //13.2
//            System.out.println("Alarm! " + playerName + " has been attack. HP = " + playerHP);           //13.3 сказать игрок атакован
            System.out.println(">>> Alarm! " + playerName + " has been attack. HP = " + playerHP + " <<<"); /**2.6 добавлено.....*/
            System.out.println("Count trap's: " + trapCount);                                               /**2.7 будет выводиться - сколько осталось*/
        }

        map[nextY][nextX] = player;                                                                        //13.4 если ловушки не было- пошел...
        map[pastY][pastX] = ready;                                                                         //13.5 где он был - пустая ячейка

    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isPlayerAlive() {
        return playerHP > 0;
    }

}
