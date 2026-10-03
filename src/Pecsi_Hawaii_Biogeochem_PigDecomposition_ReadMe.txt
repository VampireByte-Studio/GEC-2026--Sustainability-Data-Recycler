This readme file was generated on 2026-06-24 by EMILY LEANNA PECSI

GENERAL INFORMATION

Title of Dataset: Biogeochemical evaluation of soils impacted by pig carcass decomposition in a Hawaiian tropical savanna ecosystem

<provide at least two contacts>
Author/Principal Investigator Information
Name: Emily Leanna Pecsi
ORCID: 0000-0002-6725-3622
Institution: Université du Québec à Trois-Rivières
Address: 351, boulevard des Forges, Trois-Rivières (Québec) G8Z 4M3
Email: emily.pecsi@uqtr.ca

Author/Associate or Co-investigator Information
Name: François Guillemette
ORCID:0000-0003-2333-8410
Institution:Université du Québec à Trois-Rivières
Address: 3351, boulevard des Forges, Trois-Rivières (Québec) G8Z 4M3
Email: Francois.guillemette3@uqtr.ca

Author/Associate or Co-investigator Information
Name: Shari Forbes
ORCID:0000-0001-7416-0080
Institution: University of Windsor
Address: 401 Sunset Ave, Windsor (Ontario) N9B 3P4
Email: shari.forbes@uwindsor.ca

Author/Associate or Co-investigator Information
Name: Hugo Germain
ORCID:
Institution: Université du Québec à Trois-Rivières
Address: 3351, boulevard des Forges, Trois-Rivières (Québec) G8Z 4M3
Email: hugo.germain@uqtr.ca

Author/Associate or Co-investigator Information
Name: David Carter
ORCID:0000-0003-1885-5237
Institution: Chaminade University of Honolulu
Address: 3140 Waialae Ave, Honolulu, HI 96816, United States
Email: David.taphonomy@gmail.com

Author/Associate or Co-investigator Information
Name: Mélodie B Plourde
ORCID:
Institution: Université du Québec à Trois-Rivières
Address: 3351, boulevard des Forges, Trois-Rivières (Québec) G8Z 4M3
Email: melodie.bplourde@uqtr.ca

Author/Associate or Co-investigator Information
Name: Théo Devèze
ORCID: 0009-0008-1589-930X
Institution: Université du Québec à Trois-Rivières
Address: 3351, boulevard des Forges, Trois-Rivières (Québec) G8Z 4M3
Email: Theo.deveze@outlook.fr


Date of data collection: 2022-03-30 to 2022-04-19

Geographic location of data collection: 21.290833 N, -157.804722 W

Information about funding sources that supported the collection of the data: 

Canada 150 Research Chair in Forensic Thanatology, the Natural Sciences and Engineering Research Council of Canada (NSERC), Fonds de recherche du Québec – Nature et technologies (FRQNT), Micas Globalink

SHARING/ACCESS INFORMATION

Licenses/restrictions placed on the data: Creative Commons Attribution 4.0 International (CC BY 4.0)

Links to publications that cite or use the data: TBD

Links to other publicly accessible locations of the data: None

Links/relationships to ancillary data sets: https://doi.org/10.5683/SP3/DEH8FG

Was data derived from another source?
If yes, list source(s): None

Recommended citation for this dataset: 

Pecsi, E.L., Carter, D.O., Plourde, M.B., Devèze, T., Germain, H., Forbes, S., and Guillemette, F. (2026). Biogeochemical evaluation of soils impacted by pig carcass decomposition in a Hawaiian tropical savanna ecosystem [dataset]. Université du Québec à Trois-Rivières. 


DATA & FILE OVERVIEW

File List: 
Complete dataset: Pecsi_Hawaii_Biogeochem_PigDecomposition.csv
ReadMe file: Pecsi_Hawaii_Biogeochem_PigDecomposition_ReadMe.txt

Relationship between files, if important: No

Additional related data collected that was not included in the current data package: 

Are there multiple versions of the dataset? No


METHODOLOGICAL INFORMATION

Soil slurries - Soil was airdried for 1 week then sieved to 2mm. 1:40 dry soil to ultra pure water mixture was shaken overnight at 4C. Soil particles were allowed to settle for 30 minutes. Supernatant was collected,buffered to 0.001N NaHCO3, then passed through either GF/F (0.7 um) or GF/D (2.7 um) pre-combusted (500C, 4hr) glass microfiber filters. 

Bacterial abundance (BA) - Bacterial cells were extracted from soil using a Nycodenz density gradient, according to the protocol of Khalili et al. (2019, DOI 10.1128/msphere.00435-19). Extracts were stained to 2.5X SYBR Safe DNA gel and incubated in the dark for 15 minutes. Cells were enumerated on a CytoFLEX-S (Beckman Coulter) flow cytometer with a 488 nm solid-state laser. Daily instrument performance and flow rate was verified and calibrated according to manufacturer instructions and CytoFLEX Daily QC fluorospheres. Events were registered on a log-scale of FITC and PerCP channels at an acquisition threshold of 10,000. Stained cells were gated using CytExpert v2.6 software and the strategy of Hammes and Egli (2005, DOI 10.1021/es048277c).

Bacterial respiration (BR)- A SDR SensorDish and 4 mL vials equipped with PS5t optical oxygen sensors were used to determine bacterial respiration (BR) rates in GF/D filtrates. Vials were incubated in the dark and at room temperature (~20C). Readings were automatically registered every 60 min for up to 1.5 weeks or until O2 concentrations had plateaued. The rate of bacterial O2 consumption was calculated from the slope of O2 (mg/L) plotted over time. This was converted to the rate of carbon consumption using a respiratory quotient of 0.95. 

DOC - GF/F filtrates were first acidified to a minimum pH 2 (HCl 37%). DOC was then measured on a Sievers M9 Portable TOC analyzer (GE Analytical Instruments, Colorado). Instrument performance was verified again a  five-point potassium hydrogen phthalate calibration curve.

Optical measures - Absorbance spectra (200-800nm) of GF/F filtrates were measured on a Carey 100 UV-Vis Spectrophotometer (Agilent, California) using a 1cm quartz cuvette. Fluorescence excitation (230-540 nm) and emission (300-600 nm) spectra of GF/F filtrates were measured on a Carey Eclipse Fluorescence Spectrometer (Agilent, California) using a 1cm glass cuvette. The drEEM toolbox for MatLab was used to calculate optical indices (HIX, BIX, FI, SR) and to fit a splif-half validated PARAFAC model. 


Environmental/experimental conditions: Tropical savanna ecosystem. Silty clay soil (Pamoa soil series). Surface deposition of 40kg pig carcasses (n=3). 

Describe any quality-assurance procedures performed on the data: NA

People involved with sample collection, processing, analysis and/or submission: E.L. Pecsi


DATA-SPECIFIC INFORMATION FOR: Pecsi_Hawaii_Biogeochem_PigDecomposition.csv

Number of variables: 14

Number of cases/rows: 116

Variable List: 

Pig, identifier of pig carcass in which soil was collected around
Phase, decomposition phase
Distance, distance from pig carcass, cm

BA, absolute cell count, cells/gSoil
BR, bacterial respiration, ugC/gSoil/hour
DOC, dissolved organic carbon, mgC gSoil-1 
FI, fluorescence index
HIX, humification index
FRESH, freshness index
BIX, biological index
Sr, spectral slope ratio 
pC1, percent contribution of PARAFAC component 1 (Terrestrial humic-like), %
pC2, percent contribution of PARAFAC component 2 (Microbial humic-like), %
pC3, percent contribution of PARAFAC component 3 (Microbial protein-like), %
pC4, percent contribution of PARAFAC component 4 (Terrestrial phenol-like), %

Missing data codes: NA

Specialized formats or other abbreviations used: m50 and m20 denote samples that were respectively taken at 50 cm and 20 cm uphill from the pig carcass. 