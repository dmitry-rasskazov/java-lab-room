package com.company.timus;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EkaterinsWell
{
    private static final InputStream console = new BufferedInputStream(System.in, 128);

    private static final float SQRT_TWO = (float) Math.pow(2, 0.5);

    private static final float SQRT_THREE = (float) (Math.pow(3, 0.5) * 0.5);

    public static void main(String[] args) throws IOException {
        byte wellType = nextByte(), buffType, buffSize;
        float wellSize = nextByte();
        byte N = nextByte(), result = 0;

        if(1 == wellType) {
            wellSize *= 2;
        } else if(2 == wellType) {
            wellSize *= SQRT_TWO;
        }

        for(byte i = 0; i < N; i++)
        {
            buffType = nextByte();
            buffSize = nextByte();

            if(1 == buffType && buffSize*2 <= wellSize) {
                result++;
            } else if(2 == buffType && buffSize <= wellSize) {
                result++;
            } else if(3 == buffType && (buffSize * SQRT_THREE) <= wellSize) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static byte nextByte() throws IOException {
        byte result = 0, count = 0;
        char character;
        int buf;
        while ((buf = console.read()) != -1 && (character = (char) buf) >= '0' && character <= '9') {
            result = (byte) (result * 10 + (character - '0'));
            count++;
        }

        if (count > 0) {
            return result;
        }

        return nextByte();
    }
}

/**
 * 1572. Екатеринозаводский колодец
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Чуть больше месяца прошло с тех пор, как две команды Уральского государственного университета вернулись со сборов программистов, проходивших в прекрасном городе Екатеринозаводске. Северный город так впечатлил их, что им захотелось непременно туда вернуться. Известная городская легенда гласит, что чем больше крышек от канализационных люков ты закинешь в знаменитый Колодец на Набережной, тем раньше ты вернёшься в Екатеринозаводск. Программисты уже обзавелись крышками от люков и теперь хотят узнать, сколько же из них смогут пролезть в Колодец.
 * Как известно, и отверстие колодца, и крышки от люков в Екатеринозаводске имеют форму круга, квадрата или равностороннего треугольника. Крышку можно считать абсолютно плоской, при этом разрешается каким угодно образом поворачивать и перемещать её в пространстве.
 * Исходные данные
 * Обозначим круг цифрой 1, квадрат — цифрой 2, а треугольник — цифрой 3. Назовём это число типом фигуры. Размером круга мы будем называть его радиус, а размером квадрата и треугольника — длину стороны. В первой строке через пробел записаны два числа — тип и размер Колодца на Набережной. Во второй строке записано число N — количество крышек, собранных программистами. (1 ≤ N ≤ 100). В каждой из следующих N строк через пробел записаны тип и размер очередной крышки от люка. Все размеры — целые числа в промежутке от 1 до 100.
 * Результат
 * Выведите количество крышек от люков, которые удастся закинуть в Колодец программистам.
 * Примеры
 * исходные данные	результат
 *
 * 2 10
 * 3
 * 3 20
 * 1 5
 * 2 11
 *
 *
 *
 * 2
 *
 * 1 5
 * 2
 * 2 10
 * 1 6
 *
 *
 *
 * 1
 */
