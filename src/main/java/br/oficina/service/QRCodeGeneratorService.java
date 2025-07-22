package br.oficina.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import br.oficina.models.QRCode;

@Service
public class QRCodeGeneratorService {
	
	
	    

	   

	    private static final String FORMAT_INDICATOR = "000201";
	    private static final String ACCOUNT_INFORMATION = "26";
	    private static final String MERCHANT_CATEGORY_CODE = "52040000";
	    private static final String TRANSACTION_CURRENCY = "5303986540";
	    private static final String COUNTRY_CODE = "5802BR";
	    private static final String CODE_MERCHANT_NAME = "5908";
	    private static final String CODE_MERCHANT_CITY = "600";
	    private static final String ADD_DATA_FIELD_TEMPLATE = "62";

	    private static String CRC16CCITT(String payload) {
	        int crc = 0xFFFF;          // initial value
	        int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12)

	        byte[] bytes = payload.getBytes(Charset.defaultCharset());

	        for (byte b : bytes) {
	            for (int i = 0; i < 8; i++) {
	                boolean bit = ((b   >> (7-i) & 1) == 1);
	                boolean c15 = ((crc >> 15    & 1) == 1);
	                crc <<= 1;
	                if (c15 ^ bit) crc ^= polynomial;
	            }
	        }

	        crc &= 0xffff;
	        return Integer.toHexString(crc);
	    }
	    
	    public static void main(String[] args) {
	    	generatePixQrCode("5.00",,"jaquelinevl90@protonmail.com", "Curitiba","Jaqueline Varczinczak Lemke");
		}

	    public void generatePixQrCode(String valorTotal, long identificadorTransacao,String CHAVE_PIX,  String CIDADE, String BENEFICIARIO) {

	        String MERCHANT_ACCOUNT_INFORMATION_STRING = "0014BR.GOV.BCB.PIX01" + CHAVE_PIX.length() +
	            CHAVE_PIX;

	        String descricao = String.valueOf(identificadorTransacao);
	        String txid = "05" + String.format("%02d", descricao.length()) + descricao;

	        String payload = FORMAT_INDICATOR +
	                        ACCOUNT_INFORMATION +
	                        MERCHANT_ACCOUNT_INFORMATION_STRING.length() +
	                        MERCHANT_ACCOUNT_INFORMATION_STRING +
	                        MERCHANT_CATEGORY_CODE +
	                        TRANSACTION_CURRENCY +
	                        valorTotal.length() +
	                        valorTotal +
	                        COUNTRY_CODE +
	                        CODE_MERCHANT_NAME +
	                        BENEFICIARIO +
	                        CODE_MERCHANT_CITY +
	                        CIDADE.length() +
	                        CIDADE +
	                        ADD_DATA_FIELD_TEMPLATE +
	                        txid.length() +
	                        txid + "6304";

	        String CRC = CRC16CCITT(payload);
	        QRCode qrcode = new QRCode();
	        qrcode.setDescricao(descricao);
	        
	        gerarQrCode(qrcode);
	        // return payload + CRC.toUpperCase();
	    }
	
	
	// Driver code
    public void gerarQrCode(QRCode qrcode)
        throws WriterException, IOException,
               NotFoundException{

        
        // The path where the image will get saved
        String path = "C:\\workspace\\QRCodes\\demo.png";

        // Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);

        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        createQR(qrcode.getDescricao(), path, charset, hashMap, 200, 200);
        System.out.println("QR Code gerado com sucesso! ");
    }
    
    // Function to create the QR code
    public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
        throws WriterException, IOException{

        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }
}
