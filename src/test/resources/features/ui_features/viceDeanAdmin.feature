Feature: US023 Admin Vice Dean olusturabilmeli

@US023-TC001 @regression
Scenario: Admin Vice Dean olusturabilmek icin tum bilgileri girebilmeli
Given Admin managementonschools adresine gider
Then  Admin first Login butonuna tiklar.
Then  Admin User Name girer.
And   Admin Password girer.
And   Admin Login butonuna tiklar.
And   Admin MENU butonuna tiklar.
And   Admin acilan menuden Vice Dean buttonuna tiklar.
And   Admin tum alanlari doldurur.
And   Admin submit butonuna tiklar.
And   Admin Vice Dean olusturdugunu dogrular.