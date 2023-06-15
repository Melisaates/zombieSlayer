# zombieSlayer

Learning Objectives:
- Concurrency

Bu proje, bir zombi istilasını temizlemek için çoklu iş parçacığı (thread) kullanarak bir simülasyon oluşturma üzerine odaklanmaktadır. Sadece bir silahınız olduğu için kendinizi ve birkaç arkadaşınızı, bir odada yer alan ve sokaka çıkan birden fazla kapıya sahip bir odayı güvence altına almaya çalışıyorsunuz.

Zombiler yavaş hareket ettikleri için genel olarak onları kontrol etmek kolaydır. Arkadaşlarınızdan her biri bir kapıyı kontrol ederken, bireysel zombilere izin verir ve giren zombi sayısını takip eder. Siz ise odanın merkezinde durarak girmiş olan zombileri elimine etmeye çalışır ve öldürdüklerinizi sayarsınız.

Açıkça çok fazla zombi istemiyorsunuz. Odada herhangi bir anda 100'den fazla zombi olması durumunda ölürsünüz. 100 zombiyi öldürebilirseniz güvende olursunuz. Bu hedefe ulaşmanın tek yolu, sadece sokaka açılan yeterli sayıda kapıya sahip bir oda bulmaktır.

Projenin amacı, ölden önce 100 zombiyi öldürebileceğiniz en yüksek kapı sayısını bulmak için kod yazmaktır.

Kullanılan Sınıflar
*********

ZombieCounter:
--
Bu sınıf, odadaki zombi sayısını ve öldürülen zombilerin sayısını takip etmek için yöntemlere sahiptir. Aşağıdaki yöntemleri içerir:

    zombieEntered(): Odaya giren zombi sayısını takip eder.
    zombieKilled(): Öldürülen zombi sayısını takip eder.
    tooManyZombiesInTheRoom(): Odadaki zombi sayısı 100 veya daha fazla ise true döner.
    killed100Zombies(): 100'den fazla zombi öldürüldüyse true döner.
    zombiesExist(): Odada en az bir zombi varsa true döner.
    getKilledCount(): Öldürülen zombi sayısını döner.
    getInTheRoomCount(): Odadaki zombi sayısını döner.
    
******************

DoorMan:
--
Bu sınıf, zombi sayısını takip etmek için ZombieCounter nesnesine sahip olmalıdır. Aşağıdaki şekilde bir yapıcı metodu bulunur.

java

public DoorMan(ZombieCounter zombieCounter) { }

Her DoorMan iş parçacığı, her 2ms'de bir zombiyi içeri alır (ZombieCounter'dan ilgili yöntemi çağırarak) ve kabul edilen zombi sayısını takip eder. DoorMan iş parçacığı, odada çok fazla zombi (100'den fazla) olduğunda veya Slayer tarafından 100'den fazla zombi öldürüldüğünde sonlanır.

********************

Slayer:
-
Bu sınıf da zombi sayısını takip etmek için ZombieCounter nesnesine sahip olmalıdır. Aşağıdaki şekilde bir yapıcı metodu bulunur:

  public Slayer(ZombieCounter zombieCounter) { }

Slayer her 2ms'de bir bir zombiyi öldürür (ancak önce zombi olup olmadığını kontrol etmelidir) ve öldürülen zombi sayısını takip eder (ZombieCounter nesnesinden ilgili yöntemi çağırarak). Slayer iş parçacığı, odada çok fazla zombi (100'den fazla) olduğunda veya 100'den fazla zombi öldürüldüğünde sonlanır.

************

Simulator:
--
Bu sınıf, projenin ana yönetimini sağlar. main yöntemi, n DoorMan iş parçacıklarını (n komut satırı argümanı olarak alınır) ve bir Slayer iş parçacığını oluşturur ve başlatır. Tüm iş parçacıkları işlerini tamamladığında, ana iş parçacığı 100 zombi öldürüldü veya zombiler tarafından öldürüldüğünüzü kontrol eder ve ekrana yazdırır.
