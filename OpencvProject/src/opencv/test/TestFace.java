package opencv.test;
import java.util.List;
 
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
 
public class TestFace {
	public static String filePath="D:\\test\\timg.jpg";
	public static String outputPath="D:\\test\\timg.jpg";
	
	public static void main(String[] args){
		TestFace testFace=new TestFace();
		testFace.faceDetect();
	}
	
	public List<Rect> faceDetect(){
		
		Mat image = Imgcodecs.imread(filePath);
		String facePath="D:\\opencv\\opencv\\sources\\modules\\java\\common_test\\res\\raw\\lbpcascade_frontalface.xml";
        CascadeClassifier faceDetector = new CascadeClassifier(facePath);
        MatOfRect faceDetections = new MatOfRect();
        
        faceDetector.detectMultiScale(image, faceDetections);  
        for (int i=0;i<faceDetections.toArray().length;i++){
        	Rect rect=faceDetections.toArray()[i];
        	Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x  
                + rect.width, rect.y + rect.height), new Scalar(255, 0, 0));
        }
        
        
        //Piant the Rect of face
		Mat srcImg = Imgcodecs.imread(filePath);
		int fullW = srcImg.width();
		int fullH = srcImg.height();
		
		int FareaX=(int)(fullW*0.75);
		int FareaY=fullH/2;
		int FareaWid=fullW/4;
		int FareaHeight=fullH/4;
		
		int one_thirdH = fullH/3;
		
		Imgproc.rectangle(image, new Point(FareaX, FareaY), new Point(FareaX  
                +FareaWid, FareaY + FareaHeight), new Scalar(0, 255, 0));
		Imgcodecs.imwrite(outputPath, image);
        
        return faceDetections.toList();
    }
}