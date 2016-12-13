package benchmark;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;

import annotation.AnnotationOrch;
import annotation.OneHopRelationQuery;
import annotation.relationAnnotationToken;
import init.initializer;
import phrase.phrase;
import phrase.phraseOrch;
import phraseMerger.phraseMergerOrch;
import queryConstructor.SparqlSelector;
import question.quesOrch;
import question.questionAnnotation;
import token.token;
import utils.parseQald;
import utils.qaldQuery;
import utils.queryExecutor;

public class qald6 {
/*
 * Class executes the QALD6 train dataset. And comapres the results with the sparql-answers provided by the qald
 * 
 * */
	public static void main(String args[]){
		//initializing the pipeline
		initializer init = new initializer();
		//parsing the qaldjson file for answers.
		ArrayList<String[]> qaldTuple = parseQald.parseQald6("src/main/resources/qald-6-train-multilingual.json");
		Integer counter = 0;
		Integer query_number = 0;
		Integer temp_counter = 0;
		for(String[] temp: qaldTuple){
			System.out.println(query_number);
			query_number = query_number + 1;
			if(temp_counter < 19){
				temp_counter = temp_counter + 1;
				continue;
			}
			String question = temp[0];
			String sparql = temp[1];
			
			//Group by query apprently does not workso skipping it 
			
			if (sparql.contains("GROUP BY") || sparql.contains("Breaking_Bad")){
				//Breaking_Bad query is no. 20
				continue;
			}
			if(!sparql.equals("")){
				//TODO: replaceAll should have more factors. 
				sparql = sparql.replaceAll("rdf:type", "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>").replaceAll("xsd:integer", "<http://www.w3.org/2001/XMLSchema#>");
				System.out.println("the qald query is " + sparql);
				ArrayList<String> qald_result = qaldQuery.returnResultsQald(sparql);
				ArrayList<String> askNow_answer = executeQuestion.execute(question,true);
				if (askNow_answer != null){
					if(askNow_answer.containsAll(qald_result) && qald_result.containsAll(askNow_answer)){
						System.out.println("Atleast one right answer");
						counter = counter + 1;
						
					}
				}
				System.out.println("********&&&*******" + counter);
				
			}
		}
	}
	
	//TODO: Add this to utils pacakage.

}
