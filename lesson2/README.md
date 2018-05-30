> За основу взят код из методички

* Создал аннотацию *`@NotAvailable`* с обязательным элементом `fallbackClass` с типом `Class`.
* Создал класс `NotAvailableBFPP`, который имплементирует `BeanFactoryPostProcessor` интерфейс.
Он ищет бины помеченные аннотацией *`@NotAvailable`* и подменяет класс бина на указанный в `fallbackClass`.