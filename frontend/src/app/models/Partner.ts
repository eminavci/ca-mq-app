export class Partner {
    id: number;
    alias: string;
    type: string;
    direction:string;
    application: string;
    processFlowType: string;
    description: string;


    constructor(){
        this.id = 0;
        this.alias = '';
        this.type = '';
        this.direction = 'INBOUND';
        this.application = '';
        this.processFlowType = 'MESSAGE';
        this.description = '';
    }

}