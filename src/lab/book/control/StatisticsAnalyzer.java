package lab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import lab.book.entity.Magazine;
import lab.book.entity.Novel;
import lab.book.entity.Publication;
import lab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications){
		Map<String, Integer> typeCount = new HashMap<String, Integer>();
		Map<String, Integer> typeTotalPrice = new HashMap<String, Integer>();
		
		for (Publication pub : publications) {
			String type = getPublicationType(pub);
			int price = pub.getPrice();
			
			typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
			typeTotalPrice.put(type, typeTotalPrice.getOrDefault(type, 0) + price);
		}
		
		Map<String, Double> averagePriceByType = new HashMap<String, Double>();
		for (String type : typeCount.keySet()) {
			double average = typeTotalPrice.get(type) / typeCount.get(type);
			averagePriceByType.put(type, average);
		}
		return averagePriceByType;
	}
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCount = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        int total = publications.length;
        for (String type : typeCount.keySet()) {
            double percentage = (typeCount.get(type) * 100.0) / total;
            distribution.put(type, percentage);
        }

        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            String pubDate = pub.getPublishingDate();
            if (pubDate.startsWith(year)) {
                count++;
            }
        }
        return (count * 100.0) / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }
        System.out.println();

        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("2. 출판물 유형 분포:");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }
        System.out.println();

        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율:" + df.format(ratio2007) + "%");
    }
}

