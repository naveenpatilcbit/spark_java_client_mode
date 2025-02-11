package com.example;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

import org.apache.spark.SparkConf;

public class MainApplication {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("Java count example").setMaster("k8s://https://127.0.0.1:6443")
				.set("spark.executor.instances", "2").set("spark.executor.cores", "1")
				.set("spark.executor.memory", "500m").set("spark.dynamicAllocation.enabled", "false")
		.set("spark.kubernetes.container.image", "apache/spark:latest").set("spark.dynamicAllocation.enabled", "false")
		.set("spark.kubernetes.namespace", "default").set("spark.kubernetes.authenticate.driver.serviceAccountName", "spark");
		/* .set("spark.kubernetes.kubeconfig", "/Users/naveenkumarpatil/.kube/config"); */
		
		JavaSparkContext sc = new JavaSparkContext(conf);
						
		// Example: Parallelize a list and perform a word count	
		JavaRDD<String> data = sc.parallelize(java.util.Arrays.asList("Hello", "Spark", "Hello", "Java", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "Hello", "Spark",
				"Hello", "Java", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi",
				"lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
				"ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date",
				"elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya",
				"quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam",
				"zucchini", "Hello", "Spark", "Hello", "Java", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "Hello", "Spark", "Hello", "Java", "apple", "banana",
				"cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine",
				"orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet", "watermelon",
				"xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig", "grape",
				"honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini", "apple",
				"banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango",
				"nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "violet",
				"watermelon", "xigua", "yam", "zucchini", "apple", "banana", "cherry", "date", "elderberry", "fig",
				"grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry",
				"strawberry", "tangerine", "ugli", "violet", "watermelon", "xigua", "yam", "zucchini"

		));

		JavaPairRDD<String, Integer> nameCounts = data.mapToPair(name -> new Tuple2<>(name, 1))
				.reduceByKey((count1, count2) -> count1 + count2);

		// Collect and display the counts
		for (Tuple2<String, Integer> entry : nameCounts.collect()) {
			System.out.println(entry._1() + " : " + entry._2());
		}

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
