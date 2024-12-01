import { Component, inject, OnInit } from '@angular/core';
import { Partner } from '../../models/Partner';
import { FormsModule } from '@angular/forms';
import { PartnerService } from '../../services/partner.service';
import { RestResponse } from '../../models/RestResponse';

@Component({
  selector: 'app-partner',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './partner.component.html',
  styleUrl: './partner.component.css'
})
export class PartnerComponent implements OnInit{
 

  partnerSevice = inject(PartnerService);
  partnerObj: Partner = new Partner();
  partners: Partner[] = [];

  


  onSavePartner() {
    this.partnerSevice.savePartner(this.partnerObj).subscribe( {
      next: (res) => {
        this.partnerObj = new Partner();
        this.loadAllPartners();
      },
      error: (err: any) => { },
      complete: () => { }
    })
  }

  loadAllPartners(){
    this.partnerSevice.getAllPartners().subscribe((res: RestResponse) => {
      if(res.result){
        this.partners = res.data
      }
    })
  }

  deletePartner(p: Partner) {
    console.log("Denemeeee " + p)
    this.partnerSevice.deletePartner(p).subscribe((res: RestResponse) => {
        if(res.result){
          const index: number = this.partners.indexOf(p);
          if (index !== -1) {
              this.partners.splice(index, 1);
          }
          alert("Partner with ID: " + p.id + " is deleted successfuly!");
        } else {
          console.log("could not delete partner!")
        }
    });
  }

  ngOnInit(): void {
    this.loadAllPartners();
  }

}
