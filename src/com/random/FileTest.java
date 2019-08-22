package com.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileTest {
public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
	String test =  
			"05/28 10:52:19 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:19 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 20 ms\r\n" + 
			"05/28 10:52:20 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 21 ms\r\n" + 
			"05/28 10:52:20 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 22 ms\r\n" + 
			"05/28 10:52:20 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:21 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:21 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 21 ms\r\n" + 
			"05/28 10:52:22 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:22 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:23 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 21 ms\r\n" + 
			"05/28 10:52:23 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 21 ms\r\n" + 
			"05/28 10:52:23 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 22 ms\r\n" + 
			"05/28 10:52:24 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:24 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:25 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:25 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:25 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:26 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:52:26 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:27 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:27 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:27 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:28 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:28 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:29 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:29 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:30 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:30 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:31 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:52:31 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:31 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:32 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:32 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:33 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:33 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:52:33 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:34 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:34 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:35 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:35 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:35 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:36 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:36 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:37 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:37 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:37 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:38 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:38 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:39 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:39 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:39 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:40 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:40 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:52:40 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:41 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:41 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:42 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 20 ms\r\n" + 
			"05/28 10:52:42 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:43 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:43 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:43 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:44 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:44 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:44 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:45 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:45 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:52:46 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:46 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:46 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:47 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:47 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:52:47 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:48 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:48 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:49 INFO  [ACTIVE] ExecuteThread: '6' for queue: 'weblogic.kernel.Default (self-tuning)' [c13e824f-7f90-4284-b17b-cd9a317a64a0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:49 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:49 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:50 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:52:50 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:51 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:51 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:51 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:52 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:52 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:53 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:53 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:53 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:54 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:54 INFO  [ACTIVE] ExecuteThread: '6' for queue: 'weblogic.kernel.Default (self-tuning)' [c13e824f-7f90-4284-b17b-cd9a317a64a0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:54 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:55 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:55 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:56 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:52:56 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:56 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:57 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:57 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:52:58 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:58 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:58 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:52:59 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:52:59 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:52:59 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:00 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:00 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:01 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:01 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:01 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:02 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:02 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:02 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:53:03 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:03 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:03 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:04 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 19 ms\r\n" + 
			"05/28 10:53:04 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:05 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:05 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:05 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:06 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:06 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:07 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:07 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:07 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:08 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:08 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:08 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:09 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:09 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:10 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:10 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:10 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:11 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:11 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:11 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:12 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:12 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:13 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:53:13 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:14 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:14 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:15 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:15 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:15 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:16 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:16 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:16 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:17 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:17 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:18 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:53:18 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:18 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:19 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:19 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 20 ms\r\n" + 
			"05/28 10:53:20 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:20 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:20 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:21 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:21 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:21 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:22 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 28 ms\r\n" + 
			"05/28 10:53:22 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:22 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:23 INFO  [ACTIVE] ExecuteThread: '6' for queue: 'weblogic.kernel.Default (self-tuning)' [c13e824f-7f90-4284-b17b-cd9a317a64a0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:23 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:24 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:24 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:25 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:25 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:25 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:26 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:26 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:26 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:27 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:27 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:28 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:28 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:28 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:29 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:29 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:29 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:30 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:30 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:30 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:31 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:31 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:32 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:32 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:32 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:33 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:33 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:33 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:34 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:34 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:35 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:35 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:35 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:36 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:36 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:37 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:37 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:37 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:38 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:38 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:38 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:39 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:39 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:39 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:40 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:40 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:41 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:53:41 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:41 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:42 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:42 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:43 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:43 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:43 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:44 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:44 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:44 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:45 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:45 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:45 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:46 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:46 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:47 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:47 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:47 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:48 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:48 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:48 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:49 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:49 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:50 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:53:50 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:50 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:53:51 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:51 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:52 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:52 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:52 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:53 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:53 INFO  [ACTIVE] ExecuteThread: '6' for queue: 'weblogic.kernel.Default (self-tuning)' [c13e824f-7f90-4284-b17b-cd9a317a64a0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:53 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:54 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:54 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:55 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:53:55 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:55 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:56 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:56 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:53:57 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:57 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:53:57 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:58 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:58 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:58 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:53:59 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:53:59 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:00 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:00 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:00 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:01 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:01 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:01 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:02 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:02 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:03 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:03 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:03 INFO  [ACTIVE] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)' [93768287-3d82-4266-a16c-eba63b6655c9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:04 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:04 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:04 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:05 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:05 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:05 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:06 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:06 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:07 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:07 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:07 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:08 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:08 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:08 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:54:09 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:09 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:10 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:10 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:10 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:11 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:11 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:11 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:12 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:12 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:13 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:13 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:13 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:14 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:14 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:14 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:15 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:15 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:15 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:16 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:16 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:17 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:17 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:17 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:18 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:18 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:18 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:19 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:19 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:20 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:20 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:20 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:21 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:21 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:21 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:22 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:22 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:23 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 20 ms\r\n" + 
			"05/28 10:54:23 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:23 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:24 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:24 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:24 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:25 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:25 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:26 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:26 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:27 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:27 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:27 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:28 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:28 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:28 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:29 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:29 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:30 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:30 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:30 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:31 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:31 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:31 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:32 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:32 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:33 INFO  [ACTIVE] ExecuteThread: '40' for queue: 'weblogic.kernel.Default (self-tuning)' [797283cf-65e3-45b9-b53e-339232e542db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:33 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:33 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:34 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:34 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:34 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:35 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:35 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:35 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:36 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:36 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:37 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:37 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:37 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:38 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:38 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:39 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:39 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:39 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:40 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:40 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:40 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:41 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:41 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:41 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:42 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:42 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:43 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:43 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:43 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:44 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:44 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:44 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:45 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:45 INFO  [ACTIVE] ExecuteThread: '6' for queue: 'weblogic.kernel.Default (self-tuning)' [c13e824f-7f90-4284-b17b-cd9a317a64a0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:45 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:46 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:46 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:47 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:47 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:47 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:48 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:48 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:48 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:49 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:49 INFO  [ACTIVE] ExecuteThread: '9' for queue: 'weblogic.kernel.Default (self-tuning)' [64f25bf6-45ef-487a-9e07-ab3d2a272920 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:50 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:50 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:50 INFO  [ACTIVE] ExecuteThread: '2' for queue: 'weblogic.kernel.Default (self-tuning)' [7a528d47-e069-4f74-aaeb-4ccbbe8e1cfb 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:54:51 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:51 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:51 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:52 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:52 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:53 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:53 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:54:53 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:54 INFO  [ACTIVE] ExecuteThread: '28' for queue: 'weblogic.kernel.Default (self-tuning)' [12cca82a-3fc5-4615-b2cf-5d20fb0028db 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:54:54 INFO  [ACTIVE] ExecuteThread: '14' for queue: 'weblogic.kernel.Default (self-tuning)' [60660cb9-f894-46ab-b4bd-86a3a67fe6ad 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:54 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:55 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:55 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:55 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:56 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:56 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:56 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:57 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:57 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:54:58 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:58 INFO  [ACTIVE] ExecuteThread: '20' for queue: 'weblogic.kernel.Default (self-tuning)' [7631f52a-5ba2-48d1-9d87-b0855ff61cf6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:59 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:54:59 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:54:59 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:00 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:00 INFO  [ACTIVE] ExecuteThread: '6' for queue: 'weblogic.kernel.Default (self-tuning)' [c13e824f-7f90-4284-b17b-cd9a317a64a0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:00 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:01 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:01 INFO  [ACTIVE] ExecuteThread: '12' for queue: 'weblogic.kernel.Default (self-tuning)' [a6262504-e27d-4a18-983e-bb12f836c633 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:01 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:02 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:02 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:02 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:03 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:03 INFO  [ACTIVE] ExecuteThread: '13' for queue: 'weblogic.kernel.Default (self-tuning)' [dcc2a27b-917e-452b-8c5d-00de0d4896e0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:04 INFO  [ACTIVE] ExecuteThread: '4' for queue: 'weblogic.kernel.Default (self-tuning)' [cc7a267d-8e16-47cf-88a5-ecdd479c97f1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:04 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:04 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:05 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:05 INFO  [ACTIVE] ExecuteThread: '32' for queue: 'weblogic.kernel.Default (self-tuning)' [50f6e269-f902-4c71-a81f-c5fa68ba4fae 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:05 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:06 INFO  [ACTIVE] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)' [51a9831d-f158-46f8-a867-6bafa9b3cc32 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:06 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:06 INFO  [ACTIVE] ExecuteThread: '3' for queue: 'weblogic.kernel.Default (self-tuning)' [e07e00be-5159-4010-9541-219696101aed 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:07 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:07 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:07 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:08 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:55:08 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:09 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:09 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:09 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:10 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:10 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:10 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:11 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:11 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:11 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:12 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:12 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:13 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:13 INFO  [ACTIVE] ExecuteThread: '11' for queue: 'weblogic.kernel.Default (self-tuning)' [aa44612d-6d72-42f3-8f75-a1075810d978 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:13 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:14 INFO  [ACTIVE] ExecuteThread: '41' for queue: 'weblogic.kernel.Default (self-tuning)' [53af70a8-61e6-4db3-ba9c-a593b42ba710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:14 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:14 INFO  [ACTIVE] ExecuteThread: '25' for queue: 'weblogic.kernel.Default (self-tuning)' [59420545-8523-4cdb-af26-36e18a1d779d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:15 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:15 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:15 INFO  [ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)' [abcc2183-4f16-4f34-9583-703c220d4405 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:16 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:16 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:17 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:17 INFO  [ACTIVE] ExecuteThread: '10' for queue: 'weblogic.kernel.Default (self-tuning)' [913f6891-f841-43ab-9954-129502f680d7 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:55:17 INFO  [ACTIVE] ExecuteThread: '31' for queue: 'weblogic.kernel.Default (self-tuning)' [0e6a2d2d-8417-4a93-9c4b-7f45ef32bc77 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:18 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:18 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:18 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:19 INFO  [ACTIVE] ExecuteThread: '33' for queue: 'weblogic.kernel.Default (self-tuning)' [88092dbd-3533-48c0-9590-ab4a557b2376 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 11 ms\r\n" + 
			"05/28 10:55:19 INFO  [ACTIVE] ExecuteThread: '8' for queue: 'weblogic.kernel.Default (self-tuning)' [ce9389a6-53be-4296-8be2-d2fc5441c872 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:19 INFO  [ACTIVE] ExecuteThread: '29' for queue: 'weblogic.kernel.Default (self-tuning)' [65b2502b-17d2-43ae-b2dd-6af34c5351b9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:20 INFO  [ACTIVE] ExecuteThread: '23' for queue: 'weblogic.kernel.Default (self-tuning)' [b796b872-5ece-4ba4-8627-1c6c35ed2dd0 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 17 ms\r\n" + 
			"05/28 10:55:20 INFO  [ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)' [7110fb0f-04d8-46d3-ac56-6da61806c4a8 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:55:21 INFO  [ACTIVE] ExecuteThread: '7' for queue: 'weblogic.kernel.Default (self-tuning)' [bfb6330d-d3ec-4de5-ae5a-319ca5407b7b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 16 ms\r\n" + 
			"05/28 10:55:21 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 18 ms\r\n" + 
			"05/28 10:55:21 INFO  [ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)' [3745dfbe-0d98-4c5b-98df-1d7a9476515b 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:22 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:22 INFO  [ACTIVE] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)' [8c243d96-f0d1-4a11-bca3-77acc6a492cc 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:22 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:23 INFO  [ACTIVE] ExecuteThread: '37' for queue: 'weblogic.kernel.Default (self-tuning)' [43ab209d-4448-445b-babd-fb0a8df3e0fa 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:23 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:24 INFO  [ACTIVE] ExecuteThread: '5' for queue: 'weblogic.kernel.Default (self-tuning)' [679ee2a9-1342-4046-b469-aaf7f657477f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:24 INFO  [ACTIVE] ExecuteThread: '36' for queue: 'weblogic.kernel.Default (self-tuning)' [d543bc90-2c6b-492a-bdd1-0cfd034a4fe6 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:24 INFO  [ACTIVE] ExecuteThread: '22' for queue: 'weblogic.kernel.Default (self-tuning)' [e8dc9ffc-15f9-4b71-987a-dd6318a3eeaf 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:25 INFO  [ACTIVE] ExecuteThread: '27' for queue: 'weblogic.kernel.Default (self-tuning)' [c0279a9c-b949-4bbf-982e-f7b0d623319f 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:25 INFO  [ACTIVE] ExecuteThread: '34' for queue: 'weblogic.kernel.Default (self-tuning)' [5a51f4c4-d072-4748-b6c2-9a1126a599e1 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:26 INFO  [ACTIVE] ExecuteThread: '19' for queue: 'weblogic.kernel.Default (self-tuning)' [6533b58e-4a8b-4302-b624-2bbb39a6ed9e 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:26 INFO  [ACTIVE] ExecuteThread: '16' for queue: 'weblogic.kernel.Default (self-tuning)' [f5fd31bf-e3d7-4df2-86e9-ba33a8d44710 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 13 ms\r\n" + 
			"05/28 10:55:26 INFO  [ACTIVE] ExecuteThread: '26' for queue: 'weblogic.kernel.Default (self-tuning)' [667f15dd-4945-46d8-9350-8b374703692d 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:27 INFO  [ACTIVE] ExecuteThread: '39' for queue: 'weblogic.kernel.Default (self-tuning)' [5b5752bb-137a-425d-82e6-cd41c479d0a9 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 14 ms\r\n" + 
			"05/28 10:55:27 INFO  [ACTIVE] ExecuteThread: '21' for queue: 'weblogic.kernel.Default (self-tuning)' [09a950fa-dfcb-40c1-8a3a-9d1ff12ebd26 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 12 ms\r\n" + 
			"05/28 10:55:27 INFO  [ACTIVE] ExecuteThread: '15' for queue: 'weblogic.kernel.Default (self-tuning)' [ec7ece30-218d-44e2-873c-cba88248183c 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 15 ms\r\n" + 
			"05/28 10:55:28 INFO  [ACTIVE] ExecuteThread: '0' for queue: 'weblogic.kernel.Default (self-tuning)' [546de128-a6b2-43ea-82e3-10516e076358 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 21 ms\r\n" + 
			"05/28 10:55:28 INFO  [ACTIVE] ExecuteThread: '35' for queue: 'weblogic.kernel.Default (self-tuning)' [10a46ee1-a235-493d-a22b-e7193d89f390 1111 ElasticsearchUtil] Fusion OSCS End-Point took: 23 ms\r\n" + 
			"";
	
	String[] inputs = test.split("\r\n");
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	int total = 0;
	System.out.println(inputs.length);
	for (int i = 0; i < inputs.length; i++) {
		int value = Integer.parseInt(inputs[i].substring(inputs[i].length() - 5, inputs[i].length() - 3));
		total += value;
		if (max < value) {
			max = value;
		}
		if (min > value) {
			min = value;
		}
	}
	
	System.out.println("max " + max);
	System.out.println("min " + min);
	System.out.println("avg " + total/inputs.length);
	
	
	StringBuilder textContent = new StringBuilder();
			textContent = textContent.append("{" + 
            "\"fieldName\": \""+ "madhu" +"\"," + 
            "\"userGroups\": [ \"public\" ]," + 
            "\"content\": { \""+ "us" +"\": \""+ "msdfkjadsk" +"\"}" + 
            "},");
			
			System.out.println(textContent.substring(0,textContent.length()-1).toString());
			System.out.println(System.getProperty("user.name"));
			
			String header = "fa-crm-km";
			try {
	            InetAddress localMachine = InetAddress.getLocalHost();
	            String hostFullName = localMachine.getHostName();
	            String[] hostName = hostFullName.split(".");
	            if (hostName.length > 0) {
	                System.out.println(new String(hostName[0] + "-" + header));
	            } else {
	            	System.out.println(new String(hostFullName + "-" + header));
	            }
	        } catch (UnknownHostException e) {
	        	System.out.println(new String(header));
	        }
}
}
