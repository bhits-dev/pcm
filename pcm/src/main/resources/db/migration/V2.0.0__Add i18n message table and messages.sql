
use pcm;

create table i18n_message(
    id bigint not null,
    `key` varchar(255) not null,
    description varchar(255) not null,
    locale   varchar(255) not null,
    message varchar(20000) not null
) ENGINE=InnoDB;

alter table i18n_message
  add constraint pk_i18n_message primary key (id, `key`, locale);

alter table i18n_message
  add constraint u_i18n_message unique (`key`, locale);


insert into i18n_message values (1, 'PURPOSE.1.DISPLAY','Purpose of user treatment','en', 'Treatment');
insert into i18n_message values (2, 'PURPOSE.1.DISPLAY','(ES)Purpose of user treatment','es', '(ES)Treatment');
insert into i18n_message values (3, 'PURPOSE.1.DESCRIPTION','Description for Treatment','en', 'Treatment');
insert into i18n_message values (4, 'PURPOSE.1.DESCRIPTION','(ES)Description for Treatment','es', '(ES)To perform one or more operations on information for the provision of health care.');

insert into i18n_message values (5, 'PURPOSE.2.DISPLAY','Purpose of user healthcare payment','en', 'Healthcare Payment');
insert into i18n_message values (6, 'PURPOSE.2.DISPLAY','(ES)Purpose of user healthcare payment','es', '(ES)Healthcare Payment');
insert into i18n_message values (7, 'PURPOSE.2.DESCRIPTION','Description for Healthcare payment','en', 'To perform one or more operations on information for conducting financial or contractual activities related to payment for the provision of health care.');
insert into i18n_message values (8, 'PURPOSE.2.DESCRIPTION','(ES)Description for Healthcare payment','es', '(ES)To perform one or more operations on information for conducting financial or contractual activities related to payment for the provision of health care.');

insert into i18n_message values (9, 'PURPOSE.3.DISPLAY','Purpose of user Healthcare Research','en', 'Healthcare Research');
insert into i18n_message values (10, 'PURPOSE.3.DISPLAY','(ES)Purpose of user Healthcare Research','es', '(ES)Healthcare Research');
insert into i18n_message values (11, 'PURPOSE.3.DESCRIPTION','Description for Healthcare Research','en', 'To perform one or more operations on information for conducting scientific investigations to obtain health care knowledge.');
insert into i18n_message values (12, 'PURPOSE.3.DESCRIPTION','(ES)Description for Healthcare Research','es', '(ES)To perform one or more operations on information for conducting scientific investigations to obtain health care knowledge.');


-- CONSENT REVOCATION TERM

insert into i18n_message values (13, 'CONSENT_REVOCATION_TERM.1.TEXT',' Consent revocation text','en', 'I have previously signed a patient consent form allowing my providers to access my electronic health records through the Consent2Share system and now want to withdraw that consent. If I sign this form as the Patient\'s Legal Representative, I understand that all references in this form to \"me\" or \"my\" refer to the Patient.\\n\\nBy withdrawing my Consent, I understand that:\n\n 1. I Deny Consent for all Participants to access my electronic health information through Consent2Share for any purpose, EXCEPT in a medical emergency.\n 2. Health care provider and health insurers that I am enrolled with will no longer be able to access health information about me through Consent2Share, except in an emergency.\n 3. The Withdrawal of Consent will not affect the exchange of my health information while my Consent was in effect.\n 4. No Consent2Share participating provider will deny me medical care and my insurance eligibility will not be affected based on my Withdrawal of Consent.\n 5. If I wish to reinstate Consent, I may do so by signing and completing a new Patient Consent form and returning it to a participating provider or payer.\n 6. Revoking my Consent does not prevent my health care provider from submitting claims to my health insurer for reimbursement for services rendered to me in reliance on the Consent while it was in effect.\n 7. I understand that I will get a copy of this form after I sign it.');
insert into i18n_message values (14, 'CONSENT_REVOCATION_TERM.1.TEXT',' Consent revocation text','es', '(ES)I have previously signed a patient consent form allowing my providers to access my electronic health records through the Consent2Share system and now want to withdraw that consent. If I sign this form as the Patient\'s Legal Representative, I understand that all references in this form to \"me\" or \"my\" refer to the Patient.\n\nBy withdrawing my Consent, I understand that:\n\n 1. I Deny Consent for all Participants to access my electronic health information through Consent2Share for any purpose, EXCEPT in a medical emergency.\n 2. Health care provider and health insurers that I am enrolled with will no longer be able to access health information about me through Consent2Share, except in an emergency.\n 3. The Withdrawal of Consent will not affect the exchange of my health information while my Consent was in effect.\n 4. No Consent2Share participating provider will deny me medical care and my insurance eligibility will not be affected based on my Withdrawal of Consent.\n 5. If I wish to reinstate Consent, I may do so by signing and completing a new Patient Consent form and returning it to a participating provider or payer.\n 6. Revoking my Consent does not prevent my health care provider from submitting claims to my health insurer for reimbursement for services rendered to me in reliance on the Consent while it was in effect.\n 7. I understand that I will get a copy of this form after I sign it.');

-- CONSENT ATTESTATION TERM

insert into i18n_message values (15, 'CONSENT_ATTESTATON_TERM.1.TEXT',' Consent attestation text','en', 'I, ${ATTESTER_FULL_NAME}, understand that my records are protected under the federal regulations governing Confidentiality of Alcohol and Drug Abuse Patient Records, 42 CFR part 2, and cannot be disclosed without my written permission or as otherwise permitted by 42 CFR part 2. I also understand that I may revoke this consent at any time except to the extent that action has been taken in reliance on it, and that any event this consent expires automatically as follows:');
insert into i18n_message values (16, 'CONSENT_ATTESTATON_TERM.1.TEXT',' Consent attestation text','es', '(ES)I, ${ATTESTER_FULL_NAME}, understand that my records are protected under the federal regulations governing Confidentiality of Alcohol and Drug Abuse Patient Records, 42 CFR part 2, and cannot be disclosed without my written permission or as otherwise permitted by 42 CFR part 2. I also understand that I may revoke this consent at any time except to the extent that action has been taken in reliance on it, and that any event this consent expires automatically as follows:');

insert into i18n_message values (17, 'CONSENT_ATTESTATON_TERM.2.TEXT',' Consent attestation text','en', 'I, ${ATTESTER_FULL_NAME}, understand that my records are protected under the federal regulations governing Confidentiality of Alcohol and Drug Abuse Patient Records, 42 CFR part 2, and cannot be disclosed without my written permission or as otherwise permitted by 42 CFR part 2. I also understand that I may revoke this consent at any time except to the extent that action has been taken in reliance on it, and that any event this consent expires automatically as set forth below.\n \n	By signing this form below, I acknowledge that I have reviewed all of the information on this consent, confirm that such information is accurate, and accept and understand the terms of this consent.');
insert into i18n_message values (18, 'CONSENT_ATTESTATON_TERM.2.TEXT',' Consent attestation text','es', '(ES)I, ${ATTESTER_FULL_NAME}, understand that my records are protected under the federal regulations governing Confidentiality of Alcohol and Drug Abuse Patient Records, 42 CFR part 2, and cannot be disclosed without my written permission or as otherwise permitted by 42 CFR part 2. I also understand that I may revoke this consent at any time except to the extent that action has been taken in reliance on it, and that any event this consent expires automatically as set forth below.\n \n	By signing this form below, I acknowledge that I have reviewed all of the information on this consent, confirm that such information is accurate, and accept and understand the terms of this consent.');

insert into i18n_message values (19, 'CONSENT_ATTESTATON_TERM.3.TEXT',' Consent attestation text','en', 'I, ${PROVIDER_FULL_NAME}, attest that I completed this consent form granting permission to disclose ${ATTESTER_FULL_NAME}\'s records governed by 42 CFR Part 2\'s regulations protecting the Confidentiality of Alcohol and Drug Abuse Patient Records in the presence of the patient and in accordance with their preferences, and that the patient acknowledges that he or she reviewed all of the information on this consent, confirmed that such information is accurate, and has accepted and understood the terms of this consents as evidenced by his or her signature (or the signature of his or her personal representative).');
insert into i18n_message values (21, 'CONSENT_ATTESTATON_TERM.3.TEXT',' Consent attestation text','es',  '(ES)I, ${PROVIDER_FULL_NAME}, attest that I completed this consent form granting permission to disclose ${ATTESTER_FULL_NAME}\'s records governed by 42 CFR Part 2\'s regulations protecting the Confidentiality of Alcohol and Drug Abuse Patient Records in the presence of the patient and in accordance with their preferences, and that the patient acknowledges that he or she reviewed all of the information on this consent, confirmed that such information is accurate, and has accepted and understood the terms of this consents as evidenced by his or her signature (or the signature of his or her personal representative).');

