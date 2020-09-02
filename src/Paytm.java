//import sun.tracing.dtrace.DTraceProviderFactory;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * created by suhail.jahangir on 29/08/20
// */
//public class Paytm {
//
//
////    LOG - class,
////    levels - info , debug, error, trace.
//
//
//
//}
//enum LEVELS {
//    ERROR(0),
//    INFO (1),
//    DEBUG(2),
//    TRACE(3);
//
//    public int levelVal;
//    LEVELS(int i) {
//        levelVal = i;
//    }
//}
//class Logger <T> {
//    private T clazz;
//    private Lock infoLock;
//    private Lock debugLock;
//    private Lock traceLock;
//    private Lock errorLock;
//    private int logLevel;
//
//    public Logger(T type){
//        clazz = type;
//        logLevel = Config.getSttring("getLogVevel");
//
//        infoLock = new ReentrantLock();
//        debugLock = new ReentrantLock();
//        traceLock = new ReentrantLock();
//        errorLock = new ReentrantLock();
//        //initializeMap()
//    }
//
//
//
//    public void info(Object[] arr){
//        if(logLevel >= LEVELS.INFO.levelVal){
//            try{
//                infoLock.lock();
//                System.out.println(clazz.getClass().getName());
//                for(Object item : arr){
//                    System.out.print(item.toString());
//                }
//
//                infoLock.unlock();
//            }catch (Exception e){
//                System.out.print(e.getMessage());
//            } finally {
//                infoLock.unlock();
//            }
//        }
//
//    }
//    public void debug(Object[] arr){
//        if(logLevel >= LEVELS.DEBUG.levelVal){
//            try{
//                debugLock.lock();
//                StringBuilder sb = new StringBuilder();
//
//                System.out.println();
//                for(Object item : arr){
//                    sb.append(item.toString());
//                }
//
//                debugLock.unlock();
//            }catch (Exception e){
//                System.out.print(e.getMessage());
//            } finally {
//                debugLock.unlock();
//            }
//        }
//
//    }
//    public void trace(Object[] arr){
//        if(logLevel >= LEVELS.TRACE.levelVal){
//            try{
//                traceLock.lock();
//                System.out.println(clazz.getClass().getName());
//                for(Object item : arr){
//                    System.out.print(item.toString());
//                }
//                FileWriter.writeToFile();
//
//                traceLock.unlock();
//            }catch (Exception e){
//                System.out.print(e.getMessage());
//            } finally {
//                traceLock.unlock();
//            }
//        }
//
//    }
//    public void error(Object[] arr){
//        if(logLevel >= LEVELS.ERROR.levelVal){
//            try{
//                errorLock.lock();
//                System.out.println(clazz.getClass().getName());
//                for(Object item : arr){
//                    System.out.print(item.toString());
//                }
//                errorLock.unlock();
//            }catch (Exception e){
//                System.out.print(e.getMessage());
//            } finally {
//                errorLock.unlock();
//            }
//        }
//
//    }
//}
//
//class LoggerFactory{
//    static Map<Class, Logger> map = new HashMap<>();
//    public  static Logger getInstance(Class clazz) {
//        if(map.containsKey(clazz)) {
//            return map.get(clazz);
//        }
//        Logger<clazz> logger = new Logger<clazz>();
//        map.put(clazz, logger);
//        return logger;
//    }
//}
//
//@Singleton
//class FileWriter implements Writer{
//    private static File file;
//    private static Lock lock;
//    static{
//        file = new File("path of file");
//    }
//
//    public void write(String Str){
//        try{
//            lock.lock();
//            //write to file.
//            lock.unlock();
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//}
//
//class SheetWriter implements Writer{
//
//    @Override
//    public void write(String str) {
//
//    }
//}
//
//class ConsoleWriter implements Writer {
//
//    @Override
//    public void write(String str) {
//
//    }
//}
//
//interface Writer {
//    public void write(String str);
//}
//@Singleton
//class WriterHelper {
//   static Map<LEVELS, Writer> map = new HashMap<>();
//   public WriterHelper() {
//       //iniialize the map
//   }
//}
//
