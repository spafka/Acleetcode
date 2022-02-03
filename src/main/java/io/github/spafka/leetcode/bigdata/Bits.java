package io.github.spafka.leetcode.bigdata;

import org.junit.Test;

import java.io.IOException;

public class Bits {

    // 0~INT.MAX 需多少byte
    @Test
    public void _1() throws IOException {

        //7f ff ff ff
        final String MAX_HEX = Integer.toHexString(Integer.MAX_VALUE);
        //80 00 00 00
        final String MIN_HEX = Integer.toHexString(Integer.MIN_VALUE);


        long G = ((long) Integer.MAX_VALUE + 1) >> 10 >> 10 << 3 >> 10;
        //16 G

        final byte[] bitMap = new byte[(Integer.MAX_VALUE >> 3)+1];

        add(bitMap, 0);
        add(bitMap, Integer.MAX_VALUE);
        System.out.println();

    }

    /**
     * 标记指定数字（num）在bitmap中的值，标记其已经出现过<br/>
     * 将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了
     * @param bits
     * @param num
     */
    public void add(byte[] bits, int num){
        bits[getIndex(num)] |= 1 << getPosition(num);
    }

    /**
     * 判断指定数字num是否存在<br/>
     * 将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
     * @param bits
     * @param num
     * @return
     */
    public boolean contains(byte[] bits, int num){
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
    }

    /**
     * num/8得到byte[]的index
     * @param num
     * @return
     */
    public int getIndex(int num){
        return num >> 3;
    }

    /**
     * num%8得到在byte[index]的位置
     * @param num
     * @return
     */
    public int getPosition(int num){
        return num & 0x07;
    }

    /**
     * 重置某一数字对应在bitmap中的值<br/>
     * 对1进行左移，然后取反，最后与byte[index]作与操作。
     * @param bits
     * @param num
     */
    public void clear(byte[] bits, int num){
        bits[getIndex(num)] &= ~(1 << getPosition(num));
    }




}
