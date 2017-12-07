package druid;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * Created by jinhui on 2017/11/22.
 */
public class DruidTest {

    public static void main(String[] strs) throws Exception {
        String key = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI6d5GGjFZvAkeFVZKVRPFA6o6fUX+kixquHEbobZZTR4X7kMiK8/ie1Td4/UVGM10jXo0M2jDH3rN4/pDKqZ6ECAwEAAQ==";
        String chiText = "EBcb3xQ+CS6n+BbtA6QtRq0ChJi0izNchMRYwXXoyzzANFtnUcSVAon4jPisEgDCrtVpisIglW0t63rK9u5pow==";
        String res = ConfigTools.decrypt(key,chiText);
        System.out.println(res);

        String[] arr = ConfigTools.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + ConfigTools.encrypt(arr[0], "admin1234"));
    }
}
