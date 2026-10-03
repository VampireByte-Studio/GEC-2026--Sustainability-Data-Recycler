This readme file was generated on 2026-06-30 by John Cant

-
General information
-
1. Title of dataset: Daily energy flows of freestall-housed dairy cattle estimated with automated data collection

2. Dataset DOI: https://doi.org/10.5683/SP4/MS7XVT

3. Long-term contact
 Name: John Cant
 ORCID: 0000-0003-2021-1764
 Institution: University of Guelph
 Email: jcant@uoguelph.ca

4. Authors 
 Name: Patricia Kedzierski
 ORCID: 
 Institution: University of Guelph

 Name: Carolina Reyes
 ORCID: 0000-0001-7088-169X
 Institution: University of Guelph

5. Description of the dataset: Automatically recorded performance and respiratory gas exchange data from dairy cows housed in a free-stall pen.

6. Date of data collection: 2018-10-26 to 2018-11-22

7. Geographic location of the data collection: Elora and Guelph, Ontario, Canada

8. Funding information: Canada First Research Excellence Fund (THE2-020); NSERC Canada Discovery Grant; Ontario Ministry of Agriculture, Food and Rural Affairs
 
-
Sharing/access information
-
1. Licenses/restrictions placed on the dataset: CC BY 4.0

2. Links to publications that cite or use the dataset: 
Kedzierski, P.M. 2020. Estimating daily energy flows in freestall-housed dairy cattle with automated data collection. Master of Science Thesis. University of Guelph. Atrium Institutional Repository. http://hdl.handle.net/10214/17753

3. Links/relationships to related datasets: 

4. Data sources: 

5. Dataset citation: 
Cant, John; Kedzierski, Patricia; Reyes, Carolina, 2026, "Daily energy flows of freestall-housed dairy cattle estimated with automated data collection", https://doi.org/10.5683/SP4/MS7XVT, Borealis, V1.

-
Folder and file overview
-
1. File List: 

CowEnergyBalanceData.csv: raw data and calculated energy flows through individual cows averaged per week over 4 consecutive weeks

"2. Relationship between files, if important:"

-
Data-specific information for: CowEnergyBalanceData.csv
-
""
1. Number of variables: 24

2. Number of cases/rows: 116

3. Missing data codes: .

4. Variable List:

 Name: CowID
" Description: unique cow identifier"
" Value labels: N/A"
" Notes: "

Name: Date
" Description: date in YYYY-MM-DD of last day of data collection week"
" Notes:�

Name: parity
" Description: lactation number of cow"

Name: DIM
" Description: days in milk of cow"
" Notes: average for the data collection week�

Name: BCS
" Description: cow body condition score on a 5-point scale"
" Notes: average of twice daily measures after milking for the data collection week, measured by 3-D imaging camera (DeLaval)�

Name: BW_raw
" Description: cow bodyweight in kg"
" Notes: average of twice daily measures after milking for the data collection week, measured by 3-D imaging camera (DeLaval)�

Name: BWraw_chg
" Description: change in body weight in kg/d"
" Notes: average of daily body weight change for the data collection week�

Name: BW_smooth
" Description: smoothed cow bodyweight in kg"
" Notes: Locally weighted smoothing of daily raw BW values recorded by 3-D imaging camera (DeLaval), performed with the LOESS function of R using a span of 0.60 of the total timepoints. Missing daily BW values were imputed from the smoothed curves.�

Name: BWsmooth_chg
" Description: change in smoothed body weight in kg/d"
" Notes: average of daily smoothed body weight change for the data collection week�

Name: DMI_PMR
" Description: dry matter intake of partial mixed ration in kg/d"
" Notes: An average of daily measures of the PMR intake recorded by Insentec feeders (Hokofarm Group, Markness, The Netherlands)�

Name: DMI_pellet
" Description: dry matter intake of pellet in kg/d"
" Notes: An average of daily measures of the intake of a pelleted feed used to entice cows into the GreenFeed gas exchange monitor (C-Lock, Rapid City, USA)�

Name: DMI
" Description: dry matter intake in kg/d"
" Notes: An average of total daily dry matter intake from partial mixed ration + pelleted feed�

Name: CO2_g_d
" Description: daily carbon dioxide production in g/d"
" Notes: An average of daily measures of CO2 production recorded by GreenFeed gas exchange monitor (C-Lock Inc. Rapid City, USA)�

Name: O2_g_d
" Description: daily oxygen consumption in g/d"
" Notes: An average of daily measures of O2 consumption recorded by GreenFeed gas exchange monitor (C-Lock Inc. Rapid City, USA)�

Name: CH4_g_d
" Description: daily methane production in g/d"
" Notes: An average of daily measures of CH4 production recorded by GreenFeed gas exchange monitor (C-Lock Inc. Rapid City, USA)�

Name: milk
" Description: milk yield in kg/d"
" Notes: An average of daily measures of milk yield�

Name: milk_fat
" Description: milk fat percentage"
" Notes: An average of daily measures of milk fat percentage�

Name: milk_prt
" Description: milk protein percentage"
" Notes: An average of daily measures of milk protein percentage�

Name: milk_lac
" Description: milk lactose percentage"
" Notes: An average of daily measures of milk lactose percentage�

Name: MEI
" Description: metablizable energy intake in Mcal/d"
" Notes: An average of daily measures of metabolizable energy intake calculated from DMI and ME content of the diet estimated by NASEM (2021. Nutrient Requirements of Dairy Cattle)�

Name: milkE
" Description: milk energy output in Mcal/d"
" Notes: An average of daily measures of milk energy output calculated as (0.0929 � Fat% + 0.0585 � CP% + 0.0395 � Lactose%) � milk yield, according to NASEM (2021. Nutrient Requirements of Dairy Cattle)�

Name: HP_GreenFeed
" Description: heat production in Mcal/d"
" Notes: An average of daily measures of whole-body heat production calculated as (1.185 + 3.841/RQ � QCO2)/1000 where RQ is the volume ratio of CO2 production to O2 consumption, and QCO2 is the daily volume of CO2 production, according to Kaufmann et al. (2011. https://doi.org/10.3168/jds.2010-3658)�

Name: RE
" Description: retained energy in Mcal/d"
" Notes: An average of daily measures of energy retained in body and milk calculated as MEI - HP�

Name: tissueE
" Description: tissue energy retention in Mcal/d"
" Notes: An average of daily measures of energy retained in the body calculated as RE - milkE�

-
Methodological information
-
1. Description of methods used for collection/generation of data: Cows were housed in a free-stall pen equipped with a stationary GreenFeed gas exchange monitor (C-Lock Inc., Rapid City, USA) and 15 automated feed stations (Insentec, Hokofarm, Marknesse, The Netherlands) for a period of 4 wk.  Cows had individual free access to a partial mixed ration and water throughout the study and were milked twice daily at 0530 and 1730 h. On their return from the milking parlour, body weights and condition scores were recorded with a 3-D imaging camera (DeLaval, Tumba, Sweden). 

2. People involved with data collection, processing, analysis and/or submission: Kedzierski, Patricia; Reyes, Carolina; van der Hout, Aliena (University of Guelph).

