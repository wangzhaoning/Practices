package test;

public class MongoDemo {
	
	private void mongoStream()
    {
        CloseableIterator<PhysicalCardBean>  result = this.mongoTemplate.stream(new Query(),PhysicalCardBean.class,"tb_cards");
        result.forEachRemaining(bean->{
        });
    }
	
	private void mongoCursor()
    {
        final String tag = "start1 : "+UUID.randomUUID().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Query query = new Query();
                long total = mongoTemplate.count(query,"tb_cards");
                logger.info(tag+" : total : "+total);
                DBCursor cursor = mongoTemplate.getCollection("tb_cards").find(query.getQueryObject());
                int cnt = 0;
                int percent = 0;
                long start = System.currentTimeMillis();
                logger.info(tag+" : start at "+start);
                while(cursor.hasNext())
                {
                    DBObject doc = cursor.next();
                    cnt ++;
                    int p = cnt*100/(int)total;
                    if(p!=percent) {
                        percent = p;
                        logger.info(tag + " : processed " + percent+"%");
                        logger.info(tag+" : last doc="+doc.toString());
                    }
                }
                cursor.close();
                long end = System.currentTimeMillis();
                long used = end-start;
                long speed = total*1000/used;
                logger.info(tag+" : finished read "+total+" documents at "+end+ " and used "+used+" millsecods and speed="+speed+" d/s!");
            }
        }).start();
    }
}
